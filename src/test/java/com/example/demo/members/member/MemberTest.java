package com.example.demo.members.member;

import com.example.demo.domain.members.member.Member;
import com.example.demo.domain.members.member.dao.MemberRepository;
import com.example.demo.domain.members.member.model.Password;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("유저 등록")
    void create_member() {
        Member findMember = createMember();

        Assertions.assertThat(findMember.getEmail()).isEqualTo("yeob32@gmail.com");
    }

    Member createMember() {
        String email = "yeob32@gmail.com";
        String nickname = "yeob32";
        String passwordValue = "1234";

        Password password = Password.builder()
                .value(passwordValue)
                .build();
        Member member = Member.generalMemberBuilder()
                .email(email)
                .nickname(nickname)
                .password(password)
                .build();

        return memberRepository.save(member);
    }
}
