package com.example.demo.domain.users.history.dao;

import com.example.demo.domain.users.history.UserLoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginHistoryRepository extends JpaRepository<UserLoginHistory, Long> {
}
