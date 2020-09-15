package com.example.demo.domain.events.members;

import com.example.demo.domain.members.history.service.LoginHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberEventHandler {

    private final LoginHistoryService loginHistoryService;

    // @TransactionalEventListener
    @EventListener
    public void saveUserLoginHistoryHandler(MemberEvent memberEvent) {
        loginHistoryService.saveLoginHistory(memberEvent.getMember());
    }

    @EventListener
    public void updateUserHistoryHandler(MemberEvent memberEvent) {

    }
}
