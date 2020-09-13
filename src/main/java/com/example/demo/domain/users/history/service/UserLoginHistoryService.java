package com.example.demo.domain.users.history.service;

import com.example.demo.domain.users.history.UserLoginHistory;
import com.example.demo.domain.users.history.dao.UserLoginHistoryRepository;
import com.example.demo.domain.users.history.enums.Channel;
import com.example.demo.domain.users.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserLoginHistoryService {

    private final UserLoginHistoryRepository userLoginHistoryRepository;

    @Transactional
    public void saveUserLoginHistory(User user) {
        userLoginHistoryRepository.save(UserLoginHistory.builder()
                .user(user)
                .channel(Channel.MOBILE)
                .ip("123.123.123.123")
                .build());
    }
}
