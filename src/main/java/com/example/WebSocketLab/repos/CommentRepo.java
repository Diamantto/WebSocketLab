package com.example.WebSocketLab.repos;

import com.example.WebSocketLab.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
