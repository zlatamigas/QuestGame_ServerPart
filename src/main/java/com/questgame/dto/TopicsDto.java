package com.questgame.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopicsDto {
    private final MessageType messageType = MessageType.topics;
    String[] topics;
}
