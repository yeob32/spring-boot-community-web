package com.example.demo.domain.users.user.dto;

import com.example.demo.domain.users.user.User;
import com.example.demo.domain.users.user.model.Password;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUserDto {

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Getter
    public static class SignUpReq {
        private String email;
        private String nickname;
        private String password;

        @Builder
        public SignUpReq(String email, String nickname, String password) {
            this.email = email;
            this.nickname = nickname;
            this.password = password;
        }

        public User toEntity() {
            return User.generalUserBuilder()
                    .email(email)
                    .nickname(nickname)
                    .password(Password.builder()
                            .value(password)
                            .build())
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class SignInReq {
        private String email;
        private String password;

        @Builder
        public SignInReq(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }
}
