package com.questgame.dao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private long id;
    private String name;
    private char[] password;
    private int score = 0;

    public User(String name, char[] password) {
        this.name = name;
        this.password = new char[8];
    }

}
