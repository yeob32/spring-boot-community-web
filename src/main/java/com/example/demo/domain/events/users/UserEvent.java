package com.example.demo.domain.events.users;

import com.example.demo.domain.users.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserEvent {

    private final User user;
}
