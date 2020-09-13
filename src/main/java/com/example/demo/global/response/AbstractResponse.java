package com.example.demo.global.response;

import lombok.Getter;

@Getter
public abstract class AbstractResponse {

    protected static final int R_CODE_OK = 200;
    protected static final String R_STATUS_OK = "ok";

    protected int code;
    protected String status;
}
