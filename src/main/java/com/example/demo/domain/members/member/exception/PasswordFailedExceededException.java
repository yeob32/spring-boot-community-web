package com.example.demo.domain.members.member.exception;

import com.example.demo.global.exception.ApiException;
import com.example.demo.global.exception.ErrorCode;

public class PasswordFailedExceededException extends ApiException {

    public PasswordFailedExceededException(ErrorCode errorCode) {
        super(errorCode);
    }
}
