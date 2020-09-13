package com.example.demo.users.user;

import com.example.demo.domain.users.user.User;
import com.example.demo.domain.users.user.application.SignUserService;
import com.example.demo.domain.users.user.application.UserService;
import com.example.demo.domain.users.user.dto.SignUserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    SignUserService signUserService;
    @Autowired
    UserService userService;

    @Test
    @DisplayName("유저 닉네임 변경 테스트")
    void change_user_nickname() {
        String email = "yeob32@gmail.com";
        String nickname = "yeob";
        String password = "1234";

        SignUserDto.SignUpReq reqDto = SignUserDto.SignUpReq.builder().email(email).nickname(nickname).password(password).build();

        User savedUser = signUserService.signUp(reqDto);
        User findUser = userService.getUser(savedUser.getId());
        Assertions.assertThat(findUser.getNickname()).isEqualTo(nickname);

        String changeNickname = "sykim";
        userService.changeNickname(findUser.getId(), changeNickname);
        User changedUser = userService.getUser(savedUser.getId());
        Assertions.assertThat(changedUser.getNickname()).isEqualTo(changeNickname);
    }
}
