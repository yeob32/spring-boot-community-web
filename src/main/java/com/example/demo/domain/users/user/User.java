package com.example.demo.domain.users.user;

import com.example.demo.domain.common.model.BaseEntity;
import com.example.demo.domain.users.connection.UserConnection;
import com.example.demo.domain.users.history.UserLoginHistory;
import com.example.demo.domain.users.user.enums.AuthType;
import com.example.demo.domain.users.user.enums.UserStatus;
import com.example.demo.domain.users.user.model.Email;
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

    private Email email;

    @Column(name = "nickname", nullable = false, length = 50)
    private String nickname;

    private Password password;

    @Column(name = "cellphone")
    private String cellphone;

    @Column(name = "user_status")
    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;

    @Column(name = "auth_type")
    @Enumerated(value = EnumType.STRING)
    private AuthType authType;

    @Column(name = "tags")
    private String tag;

    @Column(name = "intro", columnDefinition = "TEXT")
    private String intro;

    @Column(name = "withdraw_date")
    private LocalDateTime withdrawDate;

    @Column(name = "dormant_date")
    private LocalDateTime dormantDate;

    @OneToOne(fetch = FetchType.LAZY)
    private UserConnection userConnection;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserLoginHistory> userLoginHistories = new ArrayList<>();

    @Builder(builderMethodName = "generalUserBuilder")
    public User(Email email, String nickname, String cellphone, Password password) {
        this.email = email;
        this.nickname = nickname;
        this.cellphone = cellphone;
        this.password = password;
    }
}
