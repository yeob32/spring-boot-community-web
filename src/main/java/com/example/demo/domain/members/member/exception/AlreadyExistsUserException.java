package com.example.demo.domain.members.member.exception;

import com.example.demo.global.exception.ApiException;
import com.example.demo.global.exception.ErrorCode;

public class AlreadyExistsUserException extends ApiException {
    public AlreadyExistsUserException(ErrorCode errorCode) {
        super(errorCode);
    }
}
