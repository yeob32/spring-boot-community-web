package com.example.demo.domain.members.member.api;

import com.example.demo.domain.members.member.Member;
import com.example.demo.domain.members.member.application.MemberService;
import com.example.demo.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/member")
@RestController
public class MemberApi {

    private final MemberService memberService;

    @GetMapping
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PutMapping("/nickname")
    public Object updateMember(String nickname) {
        memberService.changeNickname(nickname);
        return ApiResponse.ok();
    }
}
