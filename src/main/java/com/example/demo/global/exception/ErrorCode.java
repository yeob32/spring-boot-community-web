package com.example.demo.global.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    NOT_FOUND_MEMBER(404, "M001", "Not Found Member"),
    ALREADY_EXISTS_MEMBER(409, "M002", "Already Exists Member"),
    INVALID_MEMBER(401, "M003", "Invalid Member"),
    EXCEEDED_PASSWORD_FAILED_COUNT(401, "M004", "Exceeded password failed count")
    ;

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
