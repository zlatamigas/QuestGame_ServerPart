package com.questgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DifficultiesDto {
    private final MessageType messageType = MessageType.difficulties;
    int[] points;
}
