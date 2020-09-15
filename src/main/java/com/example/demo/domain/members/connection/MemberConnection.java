package com.example.demo.domain.members.connection;

import com.example.demo.domain.members.connection.enums.ProviderType;
import com.example.demo.domain.members.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "member_connection")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberConnection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "provider", nullable = false)
    private ProviderType providerType;

    @Column(name = "access_token", nullable = false)
    private String accessToken;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
