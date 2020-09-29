package com.example.demo.domain.members.member.model;

import com.example.demo.domain.members.member.exception.PasswordFailedExceededException;
import com.example.demo.global.exception.ErrorCode;
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
    public Password(final String value) {
        this.value = encodePassword(value);
        this.ttl = 1209_604; // 1209_604 is 14 days
        this.expirationDate = extendExpirationDate();
    }

    private String encodePassword(String password) {
        return password;
    }

    private LocalDateTime extendExpirationDate() {
        return LocalDateTime.now().plusSeconds(ttl);
    }

    public boolean isMatched(final String rawPassword) {
        if (failedCount >= 5) {
            throw new PasswordFailedExceededException(ErrorCode.EXCEEDED_PASSWORD_FAILED_COUNT);
        }

        boolean matches = isMatches(rawPassword);
        updateFailedCount(matches);
        return matches;
    }

    private boolean isMatches(String rawPassword) {
        return rawPassword.equals(value);
    }

    private void updateFailedCount(boolean matches) {
        if(matches) {
            this.failedCount++;
        }
    }
}
