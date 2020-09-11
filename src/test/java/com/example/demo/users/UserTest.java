package com.example.demo.users;

import com.example.demo.domain.users.user.User;
import com.example.demo.domain.users.user.dao.UserRepository;
import com.example.demo.domain.users.user.model.Email;
import com.example.demo.domain.users.user.model.Password;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("유저 등록")
    void create_user() {
        User findUser = createUser();

        Assertions.assertThat(findUser.getName()).isEqualTo("sykim");
    }

    User createUser() {
        Email email = Email.createEmail("yeob32@gmail.com");
        String name = "sykim";
        String nickname = "yeob32";
        String passwordValue = "1234";

        Password password = Password.builder()
                .value(passwordValue)
                .build();
        User user = User.generalUserBuilder()
                .email(email)
                .name(name)
                .nickname(nickname)
                .password(password)
                .build();

        return userRepository.save(user);
    }
}
