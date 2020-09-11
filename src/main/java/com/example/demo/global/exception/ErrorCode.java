package com.example.demo.global.exception;

public enum ErrorCode {

    NOT_FOUND_USER(404, "Not Found User"),
    ALREADY_EXISTS_USER(409, "Already Exists User"),
    INVALID_USER(401, "Invalid User")
    ;

    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return this.message;
    }
}
