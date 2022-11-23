package com.zph.Utils;

import lombok.Data;

@Data
public class R<T> {

    private int code;
    private String message;
    private T data;

    static public <T> R<T> success(T data) {
        R<T> r = new R<>();
        r.data = data;
        r.code = 200;
        r.message = "success";
        return r;
    }

    static public <T> R<T> error(String message) {
        R<T> r = new R<>();
        r.code = 201;
        r.message = message;
        return r;
    }
}
