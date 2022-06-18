package com.example.WebSocketLab.repos;

import com.example.WebSocketLab.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
