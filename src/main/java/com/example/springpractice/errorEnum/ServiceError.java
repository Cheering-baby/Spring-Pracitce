package com.example.springpractice.errorEnum;

public enum ServiceError {

    USER_NAME_REQUIRED(1001, "user_name is required."),
    USER_PWD_REQUIRED(1002, "user_pwd is required."),
    USER_NOT_FOUND(1003, "User not found."),
    USER_PWD_ERROR(1004, "Security password error."),
    USER_NEED_LOGIN(100, "Please login.");;


    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    private ServiceError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
