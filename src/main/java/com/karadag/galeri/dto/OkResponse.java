package com.karadag.galeri.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({
        "status",
        "date",
        "payload",
        "ErrorMessage"
})
public class OkResponse<T> {

    private Integer status;
    private T payload;
    private String ErrorMessage;
    private Date date;

    public static <T> OkResponse<T> ok(T payload) {
        OkResponse<T> r = new OkResponse<>();
        r.status = 200;
        r.payload = payload;
        r.date = new Date();
        return r;
    }
}
