package com.example.demo.domain.users.user.application;

import com.example.demo.domain.events.users.UserEvent;
import com.example.demo.domain.users.user.User;
import com.example.demo.domain.users.user.dao.UserRepository;
import com.example.demo.domain.users.user.dto.SignUserDto;
import com.example.demo.domain.users.user.exception.AlreadyExistsUserException;
import com.example.demo.domain.users.user.exception.NotFoundUserException;
import com.example.demo.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class SignUserService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;

    public void signIn(SignUserDto.SignInReq dto) {
        User findUser = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new NotFoundUserException(ErrorCode.NOT_FOUND_USER));

        findUser.getPassword().isMatched(dto.getPassword());
        findUser.updateLastConnectionTime();

        publisher.publishEvent(new UserEvent(findUser));
    }

    @Transactional
    public User signUp(SignUserDto.SignUpReq reqDto) {
        User user = reqDto.toEntity();

        checkDuplicationUser(user);
        return userRepository.save(user);
    }

    private void checkDuplicationUser(User user) {
        boolean exist = userRepository.existsByEmail(user.getEmail());
        if (exist) {
            throw new AlreadyExistsUserException(ErrorCode.ALREADY_EXISTS_USER);
        }
    }
}
