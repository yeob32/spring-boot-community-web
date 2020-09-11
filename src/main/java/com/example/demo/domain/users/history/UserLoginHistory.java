package com.example.demo.domain.users.history;

import com.example.demo.domain.users.history.enums.Channel;
import com.example.demo.domain.users.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_login_history")
public class UserLoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "channel", nullable = false, updatable = false)
    private Channel channel;

    @Column(name = "access_ip", nullable = false, updatable = false)
    private String ip;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
