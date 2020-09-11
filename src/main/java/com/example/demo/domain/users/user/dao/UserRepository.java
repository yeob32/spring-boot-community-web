package com.example.demo.domain.users.user.dao;

import com.example.demo.domain.users.user.User;
import com.example.demo.domain.users.user.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(Email email);
    boolean existsByEmail(Email email);
}
