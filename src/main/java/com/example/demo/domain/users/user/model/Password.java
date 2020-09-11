package com.example.demo.domain.users.user.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Password {

    @Column(name = "password")
    private String value;

    @Column(name = "password_expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "password_failed_count")
    private int failedCount;

    @Column(name = "password_ttl")
    private long ttl;

    @Column(name = "password_last_change_date")
    private LocalDateTime lastChangeDate;

    @Builder
    public Password(String value) {
        this.value = value;
        this.ttl = 1209_604; // 1209_604 is 14 days
        this.expirationDate = LocalDateTime.now().plusSeconds(ttl);
    }
}
