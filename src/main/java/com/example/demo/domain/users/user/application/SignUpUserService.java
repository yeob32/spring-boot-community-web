package com.example.demo.domain.users.user.application;

import com.example.demo.domain.users.user.User;
import com.example.demo.domain.users.user.dao.UserRepository;
import com.example.demo.domain.users.user.dto.SignUpDto;
import com.example.demo.domain.users.user.exception.AlreadyExistsUserException;
import com.example.demo.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class SignUpUserService {

    private final UserRepository userRepository;

    @Transactional
    public User signUp(SignUpDto.Req reqDto) {
        User user = reqDto.toEntity();

        checkDuplicationUser(user);
        return userRepository.save(user);
    }

    private void checkDuplicationUser(User user) {
        boolean exist = userRepository.existsByEmail(user.getEmail());
        if(exist) {
            throw new AlreadyExistsUserException(ErrorCode.ALREADY_EXISTS_USER);
        }
    }
}
