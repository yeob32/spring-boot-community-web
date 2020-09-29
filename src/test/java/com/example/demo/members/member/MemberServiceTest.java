package com.example.demo.members.member;

import com.example.demo.domain.members.member.Member;
import com.example.demo.domain.members.member.application.MemberService;
import com.example.demo.domain.members.member.dto.SignMemberDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("유저 닉네임 변경 테스트")
    void change_nickname() {
        String email = "yeob32@gmail.com";
        String nickname = "yeob";
        String password = "1234";

        SignMemberDto.SignUpReq reqDto = SignMemberDto.SignUpReq.builder().email(email).nickname(nickname).password(password).build();

        Member savedMember = memberService.signUp(reqDto);
        Member findMember = memberService.getMember(savedMember.getId());
        Assertions.assertThat(findMember.getNickname()).isEqualTo(nickname);

        String changeNickname = "sykim";
        memberService.changeNickname(changeNickname);
        Member changedMember = memberService.getMember(savedMember.getId());
        Assertions.assertThat(changedMember.getNickname()).isEqualTo(changeNickname);
    }
}
