package com.example.demo.domain.users.user.events;

import com.example.demo.domain.users.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserEvent {

    private final User user;
}
