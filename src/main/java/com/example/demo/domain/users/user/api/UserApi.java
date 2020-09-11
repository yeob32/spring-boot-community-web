package com.example.demo.domain.users.user.api;

import com.example.demo.domain.users.user.User;
import com.example.demo.domain.users.user.application.SignUpUserService;
import com.example.demo.domain.users.user.application.UserService;
import com.example.demo.domain.users.user.dto.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserApi {

    private final UserService userService;
    private final SignUpUserService signInUserService;

    @PostMapping(value = "/signUp")
    public Long signUp(SignUpDto.Req reqDto) {
        User user = signInUserService.signUp(reqDto);

        return user.getId();
    }
}
