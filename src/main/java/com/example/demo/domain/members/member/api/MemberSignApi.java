package com.example.demo.domain.members.member.api;

import com.example.demo.domain.members.member.Member;
import com.example.demo.domain.members.member.application.MemberService;
import com.example.demo.domain.members.member.dto.SignMemberDto;
import com.example.demo.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/member")
@RestController
public class MemberSignApi {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public ApiResponse signUp(SignMemberDto.SignUpReq reqDto) {
        Member member = memberService.signUp(reqDto);
        return ApiResponse.of(member);
    }

    @PostMapping("/signIn")
    public ApiResponse signIn(SignMemberDto.SignInReq reqDto) {
        memberService.signIn(reqDto);
        return ApiResponse.ok();
    }

    @PostMapping("/signOut")
    public ApiResponse signOut() {
        memberService.signOut();
        return ApiResponse.ok();
    }
}
