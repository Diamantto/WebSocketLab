package com.example.WebSocketLab.dto;

import com.example.WebSocketLab.domain.Message;
import com.example.WebSocketLab.domain.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
@JsonView(Views.FullMessage.class)
public class MessagePageDto {
    private List<Message> messages;
    private int currentPage;
    private int totalPages;
}
