package com.example.demo.domain.users.user.application;

import com.example.demo.domain.users.user.dao.UserRepository;
import com.example.demo.domain.users.user.events.UserEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignInUserService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;

    public boolean signIn(String email, String password) {



//        publisher.publishEvent(new UserEvent());
        return false;
    }
}
