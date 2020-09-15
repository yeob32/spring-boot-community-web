package com.example.demo.domain.members.history.service;

import com.example.demo.domain.members.history.LoginHistory;
import com.example.demo.domain.members.history.dao.LoginHistoryRepository;
import com.example.demo.domain.enums.Channel;
import com.example.demo.domain.members.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    @Transactional
    public void saveLoginHistory(Member member) {
        loginHistoryRepository.save(LoginHistory.builder()
                .member(member)
                .channel(Channel.MOBILE)
                .ip("123.123.123.123")
                .build());
    }
}
