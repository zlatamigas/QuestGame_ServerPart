package com.questgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserResultDto {
    private final MessageType messageType = MessageType.createUser;
    private Boolean alreadyExists;
    private int id ;
}
