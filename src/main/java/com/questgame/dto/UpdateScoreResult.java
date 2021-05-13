package com.questgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateScoreResult {
    private final MessageType messageType = MessageType.updateScore;
    private int score ;
}
