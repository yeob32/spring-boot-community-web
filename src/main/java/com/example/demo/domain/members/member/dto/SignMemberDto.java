package com.example.demo.domain.members.member.dto;

import com.example.demo.domain.members.member.Member;
import com.example.demo.domain.members.member.model.Password;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignMemberDto {

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

        public Member toEntity() {
            return Member.generalMemberBuilder()
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
