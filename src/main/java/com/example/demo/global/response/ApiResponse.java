package com.example.demo.global.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ApiResponse {

    private static final int RESPONSE_CODE_OK = 200;
    private static final String RESPONSE_STATUS_OK = "ok";

    private int code;
    private String status;
    private Object data;

    @Builder
    public ApiResponse(int code, String status, Object data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public static ApiResponse ok() {
        return ApiResponse.builder()
                .code(RESPONSE_CODE_OK)
                .status(RESPONSE_STATUS_OK)
                .build();
    }

    public static ApiResponse of(Object data) {
        return ApiResponse.builder()
                .code(RESPONSE_CODE_OK)
                .status(RESPONSE_STATUS_OK)
                .data(data)
                .build();
    }

}
