package com.example.demo.domain.members.member.exception;

import com.example.demo.global.exception.ApiException;
import com.example.demo.global.exception.ErrorCode;

public class NotFoundMemberException extends ApiException {
    public NotFoundMemberException(ErrorCode errorCode) {
        super(errorCode);
    }
}
