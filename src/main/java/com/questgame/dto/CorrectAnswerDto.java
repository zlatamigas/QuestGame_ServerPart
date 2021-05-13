package com.questgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CorrectAnswerDto {
    private final MessageType messageType = MessageType.correctAnswer;
    private String correctAnswer;
}
