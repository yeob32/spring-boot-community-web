package com.example.demo.domain.users.user.api;

import com.example.demo.domain.users.user.User;
import com.example.demo.domain.users.user.application.SignUserService;
import com.example.demo.domain.users.user.dto.SignUserDto;
import com.example.demo.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SignUserApi {

    private final SignUserService signUserService;

    @PostMapping("/signUp")
    public ApiResponse signUp(SignUserDto.SignUpReq reqDto) {
        User user = signUserService.signUp(reqDto);
        return ApiResponse.of(user);
    }

    @PostMapping("/signIn")
    public ApiResponse signIn(SignUserDto.SignInReq reqDto) {
        signUserService.signIn(reqDto);
        return ApiResponse.ok();
    }
}
