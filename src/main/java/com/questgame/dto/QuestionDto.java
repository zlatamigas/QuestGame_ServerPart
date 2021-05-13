package com.questgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionDto {

    private final MessageType messageType = MessageType.question;
    private long id;
    private String text;
    private String topic;
    private int difficulty;

}
