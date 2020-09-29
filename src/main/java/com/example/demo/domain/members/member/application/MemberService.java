package com.example.demo.domain.members.member.application;

import com.example.demo.domain.members.member.Member;
import com.example.demo.domain.members.member.dao.MemberRepository;
import com.example.demo.domain.members.member.dto.SignMemberDto;
import com.example.demo.domain.members.member.exception.AlreadyExistsUserException;
import com.example.demo.domain.members.member.exception.NotFoundMemberException;
import com.example.demo.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new NotFoundMemberException(ErrorCode.NOT_FOUND_MEMBER));
    }

    @Transactional
    public Member signUp(SignMemberDto.SignUpReq reqDto) {
        Member member = reqDto.toEntity();

        checkDuplicationUser(member);
        return memberRepository.save(member);
    }

    private void checkDuplicationUser(Member member) {
        boolean exist = memberRepository.existsByEmail(member.getEmail());
        if (exist) {
            throw new AlreadyExistsUserException(ErrorCode.ALREADY_EXISTS_MEMBER);
        }
    }

    public void signIn(SignMemberDto.SignInReq dto) {
        Member findMember = memberRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new NotFoundMemberException(ErrorCode.NOT_FOUND_MEMBER));

        findMember.getPassword().isMatched(dto.getPassword());
        findMember.updateLastConnectionTime();
    }

    public void signOut() {

    }

    @Transactional
    public void changeNickname(String nickname) {
//        Member member = memberRepository.findById(id)
//                .orElseThrow(() -> new NotFoundMemberException(ErrorCode.NOT_FOUND_MEMBER));
//
//        member.changeNickname(nickname);
    }
}
