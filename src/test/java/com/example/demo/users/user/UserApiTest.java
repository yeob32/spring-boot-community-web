package com.example.demo.users.user;

import com.example.demo.domain.users.history.UserLoginHistory;
import com.example.demo.domain.users.history.dao.UserLoginHistoryRepository;
import com.example.demo.domain.users.user.User;
import com.example.demo.domain.users.user.dao.UserRepository;
import com.example.demo.domain.users.user.model.Password;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserApiTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserLoginHistoryRepository userLoginHistoryRepository;

    @BeforeEach
    public void setUp() {
        createUser();
    }

    @Test
    @DisplayName("사용자 등록 테스트")
    void signUp_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/signUp")
                .param("email", "testuser@gmail.com")
                .param("nickname", "user1")
                .param("password", "1234"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("로그인 테스트")
    void signIn_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/signIn")
                .param("email", "yeob32@gmail.com")
                .param("password", "1234"))
                .andExpect(status().isOk())
                .andDo(print());

        List<UserLoginHistory> userLoginHistories = userLoginHistoryRepository.findAll();
        assertThat(userLoginHistories.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("사용자 닉네임 변경 테스트")
    void change_nickname_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/users/changeNickname/1")
                .param("nickname", "gkgkgk"))
                .andExpect(status().isOk())
                .andDo(print());

        User user = userRepository.findById(1L).get();
        assertThat(user.getNickname()).isEqualTo("gkgkgk");
    }

    User createUser() {
        String email = "yeob32@gmail.com";
        String nickname = "yeob32";
        String passwordValue = "1234";

        Password password = Password.builder()
                .value(passwordValue)
                .build();
        User user = User.generalUserBuilder()
                .email(email)
                .nickname(nickname)
                .password(password)
                .build();

        return userRepository.save(user);
    }
}
