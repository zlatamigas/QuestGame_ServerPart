package com.questgame.service.impl;

import com.questgame.dao.QuestionDao;
import com.questgame.dao.domain.Question;
import com.questgame.dto.QuestionDto;
import com.questgame.mapper.QuestionMapper;
import com.questgame.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDAO;

    @Override
    public long getTopicIndex(String topic) {
        return questionDAO.getTopicIndex(topic);
    }

    @Override
    public long getDifficultyIndex(String difficulty) {
        return questionDAO.getDifficultyIndex(Integer.parseInt(difficulty));
    }

    @Override
    public String getCorrectAnswer(long id) {
        return questionDAO.getCorrectAnswer(id);
    }

    @Override
    public QuestionDto getRandomQuestion(String topic, String difficulty) {

        Question question = questionDAO.getRandomQuestion(getTopicIndex(topic), getDifficultyIndex(difficulty));
        return (question != null ? QuestionMapper.questionToDto(question) : null);
    }

    @Override
    public QuestionDto getRandomQuestion(long topicId, long difficultyId) {
        Question question = questionDAO.getRandomQuestion(topicId, difficultyId);
        return (question != null ? QuestionMapper.questionToDto(question) : null);
    }

    @Override
    public boolean compareCorrectAnswer(long questionId, String userAnswer) {
        return questionDAO.compareCorrectAnswer(questionId, userAnswer);
    }
}

