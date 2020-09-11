package com.example.demo.domain.users.user.dto;

import com.example.demo.domain.users.user.User;
import com.example.demo.domain.users.user.model.Email;
import com.example.demo.domain.users.user.model.Password;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpDto {

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter
    public static class Req {

        private String email;
        private String nickname;
        private String password;

        @Builder
        public Req(String email, String nickname, String password) {
            this.email = email;
            this.nickname = nickname;
            this.password = password;
        }

        public User toEntity() {
            return User.generalUserBuilder()
                    .email(Email.createEmail(email))
                    .nickname(nickname)
                    .password(Password.builder()
                            .value(password)
                            .build())
                    .build();
        }
    }
}
