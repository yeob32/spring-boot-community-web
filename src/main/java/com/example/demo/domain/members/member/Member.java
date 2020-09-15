package com.example.demo.domain.members.member;

import com.example.demo.domain.common.model.BaseEntity;
import com.example.demo.domain.members.connection.MemberConnection;
import com.example.demo.domain.members.history.LoginHistory;
import com.example.demo.domain.members.member.model.Password;
import com.example.demo.domain.members.profiles.Profile;
import com.example.demo.domain.members.member.enums.AuthType;
import com.example.demo.domain.members.member.enums.MemberStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "nickname", nullable = false, length = 50)
    private String nickname;

    private Password password;

    @Column(name = "member_status")
    @Enumerated(value = EnumType.STRING)
    private MemberStatus memberStatus;

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
    private Profile profile;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MemberConnection memberConnection;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    private List<LoginHistory> userLoginHistories = new ArrayList<>();

    @Builder(builderMethodName = "generalMemberBuilder")
    public Member(String email, String nickname, Password password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    @Builder(builderMethodName = "socialUserBuilder")
    public Member(String email, String nickname, Password password, MemberConnection memberConnection) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.memberConnection = memberConnection;
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public void updateLastConnectionTime() {
        this.lastConnectionTime = LocalDateTime.now();
    }
}
