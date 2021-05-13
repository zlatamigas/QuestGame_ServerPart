package com.questgame.dao;

import com.questgame.dao.domain.Question;

public interface QuestionDao {

    long getTopicIndex(String topic);

    long getDifficultyIndex(int difficulty);

    Question getQuestion(long id);

    Question getRandomQuestion(long topicId, long difficultyId);

    String getCorrectAnswer(long id);

    boolean compareCorrectAnswer(long questionId, String userAnswer);

}
