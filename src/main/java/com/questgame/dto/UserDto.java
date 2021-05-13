package com.questgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private final MessageType messageType = MessageType.user;
    private long id;
    private final String name;
    private int score = 0;

}
