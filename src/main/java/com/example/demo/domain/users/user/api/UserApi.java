package com.example.demo.domain.users.user.api;

import com.example.demo.domain.users.user.User;
import com.example.demo.domain.users.user.application.UserService;
import com.example.demo.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserApi {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/users/changeNickname/{id}")
    public Object updateUser(@PathVariable Long id, String nickname) {
        userService.changeNickname(id, nickname);
        return ApiResponse.ok();
    }
}
