package com.example.demo.domain.events.users;

import com.example.demo.domain.users.history.service.UserLoginHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class UserEventHandler {

    private final UserLoginHistoryService userLoginHistoryService;

    // @TransactionalEventListener
    @EventListener
    public void saveUserLoginHistoryHandler(UserEvent userEvent) {
        userLoginHistoryService.saveUserLoginHistory(userEvent.getUser());
    }

    @EventListener
    public void updateUserHistoryHandler(UserEvent userEvent) {

    }
}
