package com.questgame.dao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    private long id;
    private String text;
    private String answer;
    private String topic;
    private int difficulty;

    public Question(String text, String answer, String topic, int difficulty) {

        this.text = text;
        this.answer = answer;
        this.topic = topic;
        this.difficulty = difficulty;
    }

}
