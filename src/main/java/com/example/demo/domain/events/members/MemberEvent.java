package com.example.demo.domain.events.members;

import com.example.demo.domain.members.member.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MemberEvent {

    private final Member member;
}
