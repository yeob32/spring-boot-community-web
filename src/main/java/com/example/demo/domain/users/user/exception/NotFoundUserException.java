package com.example.demo.domain.users.user.exception;

import com.example.demo.global.exception.ApiException;
import com.example.demo.global.exception.ErrorCode;

public class NotFoundUserException extends ApiException {
    public NotFoundUserException(ErrorCode errorCode) {
        super(errorCode);
    }
}
