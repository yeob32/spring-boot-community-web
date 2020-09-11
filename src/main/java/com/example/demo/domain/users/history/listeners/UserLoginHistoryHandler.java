package com.example.demo.domain.users.history.listeners;

import com.example.demo.domain.users.history.service.UserLoginHistoryService;
import com.example.demo.domain.users.user.events.UserEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@RequiredArgsConstructor
@Component
public class UserLoginHistoryHandler {

    private final UserLoginHistoryService userLoginHistoryService;

    @TransactionalEventListener
    public void handler(UserEvent userEvent) {
        userLoginHistoryService.saveUserLoginHistory(userEvent.getUser());
    }

}
