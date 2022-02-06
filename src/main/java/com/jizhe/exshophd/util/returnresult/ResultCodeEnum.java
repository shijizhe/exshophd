package com.jizhe.exshophd.util.returnresult;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"success"),

    NOT_AUTH(403,"没有权限访问"),

    FAIL(410,"fail");


    private int code;
    private String message;

    private ResultCodeEnum(int code, String message) {
        this.code=code;
        this.message=message;
    }
}
