package com.example.WebSocketLab.service;

import com.example.WebSocketLab.domain.Comment;
import com.example.WebSocketLab.domain.User;
import com.example.WebSocketLab.domain.Views;
import com.example.WebSocketLab.dto.EventType;
import com.example.WebSocketLab.dto.ObjectType;
import com.example.WebSocketLab.repos.CommentRepo;
import com.example.WebSocketLab.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    public CommentService(CommentRepo commentRepo, WsSender wsSender) {
        this.commentRepo = commentRepo;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepo.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }
}