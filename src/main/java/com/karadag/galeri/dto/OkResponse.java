package com.karadag.galeri.dto;

import lombok.Data;

@Data
public class OkResponse<T> {

    private Integer status;
    private T payload;
    private String ErrorMessage;

    public static <T> OkResponse<T> ok(T payload) {
        OkResponse<T> r = new OkResponse<>();
        r.status = 200;

        r.payload = payload;
        return r;
    }
}
