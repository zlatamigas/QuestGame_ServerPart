package com.questgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConformationDto {

    private final MessageType messageType = MessageType.confirmation;
    private Boolean passwordIsValid;
    private int id;
}
