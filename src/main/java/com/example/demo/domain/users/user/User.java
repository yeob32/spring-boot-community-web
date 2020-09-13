package com.example.demo.domain.users.user;

import com.example.demo.domain.common.model.BaseEntity;
import com.example.demo.domain.users.connection.UserConnection;
import com.example.demo.domain.users.history.UserLoginHistory;
import com.example.demo.domain.users.profiles.UserProfile;
import com.example.demo.domain.users.user.enums.AuthType;
import com.example.demo.domain.users.user.enums.UserStatus;
import com.example.demo.domain.users.user.model.Password;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "nickname", nullable = false, length = 50)
    private String nickname;

    private Password password;

    @Column(name = "user_status")
    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;

    @Column(name = "auth_type")
    @Enumerated(value = EnumType.STRING)
    private AuthType authType;

    @Column(name = "withdraw_date")
    private LocalDateTime withdrawDate;

    @Column(name = "dormant_date")
    private LocalDateTime dormantDate;

    @Column(name = "last_connection_time")
    private LocalDateTime lastConnectionTime;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserProfile userProfile;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserConnection userConnection;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserLoginHistory> userLoginHistories = new ArrayList<>();

    @Builder(builderMethodName = "generalUserBuilder")
    public User(String email, String nickname, Password password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    @Builder(builderMethodName = "socialUserBuilder")
    public User(String email, String nickname, Password password, UserConnection userConnection) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.userConnection = userConnection;
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public void updateLastConnectionTime() {
        this.lastConnectionTime = LocalDateTime.now();
    }
}
