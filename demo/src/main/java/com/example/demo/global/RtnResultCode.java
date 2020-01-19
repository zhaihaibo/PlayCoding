package com.example.demo.global;

public enum  RtnResultCode {


    FAIL(0,"FAIL"),
    SUCCESS(1, "SUCCESS");

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    RtnResultCode() {
    }

    RtnResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
