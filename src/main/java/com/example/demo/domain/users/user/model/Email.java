package com.example.demo.domain.users.user.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class Email {

    @Column(name = "email", nullable = false, unique = true)
    private String value;

    public static Email createEmail(String value) {
        Email email = new Email();
        email.value = value;

        return email;
    }
}
