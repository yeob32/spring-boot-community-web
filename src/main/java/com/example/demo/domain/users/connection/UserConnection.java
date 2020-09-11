package com.example.demo.domain.users.connection;

import com.example.demo.domain.users.connection.enums.ProviderType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_connection")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserConnection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "provider", nullable = false)
    private ProviderType providerType;

    @Column(name = "access_token", nullable = false)
    private String accessToken;
}
