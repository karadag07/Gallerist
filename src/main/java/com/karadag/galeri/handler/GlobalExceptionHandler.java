package com.karadag.galeri.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.karadag.galeri.enums.MessageType;
import com.karadag.galeri.exception.BaseException;
import com.karadag.galeri.exception.ErrorObject;

//Hataları ErrorObject zarfına koyup düzgün bir HTTP durum koduyla (400 gibi) client'a döner.
@ControllerAdvice
public class GlobalExceptionHandler {

    // Kod içinde "new BaseException(...)" ile fırlatılan her hata bu metoda düşer.
    // Örn: findById ile kayıt bulunamadığında orElseThrow() içinde fırlatılan
    // BaseException.
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorObject> handleBaseException(BaseException ex, WebRequest request) {

        // Client'a dönecek standart hata zarfını (ErrorObject) oluşturuyoruz.
        ErrorObject error = new ErrorObject(
                HttpStatus.BAD_REQUEST.value(), // HTTP durum kodu: 400 (JSON body içindeki bilgi amaçlı)
                ex.getMessage(), // BaseException'ın taşıdığı hazır mesaj (ErrorMessage.prepareErrorMessage())
                extractPath(request), // Hatanın hangi endpoint'te oluştuğu
                new Date()); // Hatanın oluştuğu an

        // Gerçek HTTP cevabını 400 (Bad Request) durum koduyla, body'sinde ErrorObject
        // ile dönüyoruz.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // @Valid ile işaretli bir DTO'da (örn: @NotNull) validasyon hatası oluştuğunda
    // Spring bu exception'ı otomatik fırlatır, biz burada yakalıyoruz.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorObject> handleValidationException(MethodArgumentNotValidException ex,
            WebRequest request) {

        // Birden fazla alan aynı anda hatalı olabileceği için mesajları burada
        // birleştiriyoruz.
        StringBuilder message = new StringBuilder();

        // Hatalı olan her alanı (field) tek tek geziyoruz.
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            message.append(fieldError.getField()) // hangi alan hatalı (örn: "carId")
                    .append(": ")
                    .append(fieldError.getDefaultMessage()) // o alana ait validasyon mesajı
                    .append("; ");
        }

        // Toplanan validasyon mesajlarını yine aynı ErrorObject zarfına koyuyoruz.
        ErrorObject apiError = new ErrorObject(
                HttpStatus.BAD_REQUEST.value(),
                message.toString(), // StringBuilder'ı normal String'e çeviriyoruz
                extractPath(request),
                new Date());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> exceptionhandle(Exception ex, WebRequest request) {
        ErrorObject error = new ErrorObject(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                MessageType.GENERAL_EXCEPTION.getMessage(),
                extractPath(request),
                new Date());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    // İsteğin path bilgisini ("uri=/xxx" formatından temizleyerek) çıkaran yardımcı
    // metot.
    // Sadece bu sınıf içinde kullanıldığı için private.
    private String extractPath(WebRequest request) {
        return request.getDescription(false).replace("uri=", "");
    }
}