package com.questgame.service;

import com.questgame.dto.QuestionDto;

public interface QuestionService {

    long getTopicIndex(String topic);

    long getDifficultyIndex(String difficulty);

    String getCorrectAnswer(long id);

    QuestionDto getRandomQuestion(String topic, String difficulty);

    QuestionDto getRandomQuestion(long topicId, long difficultyId);

    boolean compareCorrectAnswer(long questionId, String userAnswer);
}