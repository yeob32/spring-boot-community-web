package com.example.demo.domain.members.history.dao;

import com.example.demo.domain.members.history.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
}
