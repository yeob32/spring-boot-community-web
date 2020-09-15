package com.example.demo.members.member;

import com.example.demo.domain.members.history.LoginHistory;
import com.example.demo.domain.members.history.dao.LoginHistoryRepository;
import com.example.demo.domain.members.member.Member;
import com.example.demo.domain.members.member.dao.MemberRepository;
import com.example.demo.domain.members.member.model.Password;
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
public class MemberApiTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    LoginHistoryRepository loginHistoryRepository;

    @BeforeEach
    public void setUp() {
        createMember();
    }

    @Test
    @DisplayName("사용자 등록 테스트")
    void signUp_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/member/signUp")
                .param("email", "testuser@gmail.com")
                .param("nickname", "user1")
                .param("password", "1234"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("로그인 테스트")
    void signIn_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/member/signIn")
                .param("email", "yeob32@gmail.com")
                .param("password", "1234"))
                .andExpect(status().isOk())
                .andDo(print());

        List<LoginHistory> userLoginHistories = loginHistoryRepository.findAll();
        assertThat(userLoginHistories.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("사용자 닉네임 변경 테스트")
    void change_nickname_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/member/changeNickname")
                .param("nickname", "gkgkgk"))
                .andExpect(status().isOk())
                .andDo(print());

        Member member = memberRepository.findById(1L).get();
        assertThat(member.getNickname()).isEqualTo("gkgkgk");
    }

    Member createMember() {
        String email = "yeob32@gmail.com";
        String nickname = "yeob32";
        String passwordValue = "1234";

        Password password = Password.builder()
                .value(passwordValue)
                .build();
        Member member = Member.generalMemberBuilder()
                .email(email)
                .nickname(nickname)
                .password(password)
                .build();

        return memberRepository.save(member);
    }
}
