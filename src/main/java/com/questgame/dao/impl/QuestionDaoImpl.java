package com.questgame.dao.impl;

import com.questgame.dao.QuestionDao;
import com.questgame.dao.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class QuestionDaoImpl implements QuestionDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public long getTopicIndex(String topic) {

        Map<String, Object> sqlInsertParametersMap = new HashMap<String, Object>();
        sqlInsertParametersMap.put("topic", topic);
        try {
            return jdbcTemplate.queryForObject("select id from topic where name=:topic", sqlInsertParametersMap, (resultSet, rowNum) ->
                    new Long(resultSet.getLong("id")));
        } catch (DataAccessException dae) {
            return -1;
        }
    }

    @Override
    public long getDifficultyIndex(int difficulty) {

        Map<String, Object> sqlInsertParametersMap = new HashMap<String, Object>();
        sqlInsertParametersMap.put("score", difficulty);
        try {
            return jdbcTemplate.queryForObject("select id from difficulty where score=:score", sqlInsertParametersMap, (resultSet, rowNum) ->
                    new Long(resultSet.getLong("id")));
        } catch (DataAccessException dae) {
            return -1;
        }
    }

    @Override
    public Question getQuestion(long id) {

        Map<String, Object> sqlInsertParametersMap = new HashMap<String, Object>();
        sqlInsertParametersMap.put("id", id);
        try {
            return jdbcTemplate.queryForObject("SELECT q.id,q.text,q.answer,t.name,d.score " +
                    "FROM ((questions q " +
                    "INNER JOIN topic t ON t.id = q.id_topic) " +
                    "INNER JOIN difficulty d ON d.id = q.id_difficulty) " +
                    "WHERE q.id=:id", sqlInsertParametersMap, (resultSet, rowNum) ->
                    new Question(resultSet.getLong("id"),
                            resultSet.getString("text"),
                            resultSet.getString("answer"),
                            resultSet.getString("name"),
                            resultSet.getInt("score")));
        } catch (DataAccessException dae) {
            return null;
        }
    }

    @Override
    public Question getRandomQuestion(long topicId, long difficultyId) {


        Map<String, Object> sqlInsertParametersMap = new HashMap<String, Object>();
        sqlInsertParametersMap.put("topicId", topicId);
        sqlInsertParametersMap.put("difficultyId", difficultyId);

        if (topicId < 0 || difficultyId < 0)
            return null;
        try {
            return jdbcTemplate.queryForObject("SELECT q.id,q.text,q.answer,t.name,d.score " +
                    "FROM ((questions q " +
                    "INNER JOIN topic t ON t.id=:topicId AND q.id_topic=:topicId) " +
                    "INNER JOIN difficulty d ON d.id=:difficultyId AND q.id_difficulty=:difficultyId) " +
                    "ORDER BY RANDOM() " +
                    "LIMIT 1", sqlInsertParametersMap, (resultSet, rowNum) ->
                    new Question(resultSet.getLong("id"),
                            resultSet.getString("text"),
                            resultSet.getString("answer"),
                            resultSet.getString("name"),
                            resultSet.getInt("score")));
        } catch (DataAccessException dae) {
            return null;
        }

    }

    @Override
    public String getCorrectAnswer(long id) {

        Map<String, Object> sqlInsertParametersMap = new HashMap<String, Object>();
        sqlInsertParametersMap.put("id", id);
        try {
            return jdbcTemplate.queryForObject("select answer from questions where id=:id", sqlInsertParametersMap, (resultSet, rowNum) ->
                    new String(resultSet.getString("answer")));
        } catch (DataAccessException dae) {
            return null;
        }
    }

    @Override
    public boolean compareCorrectAnswer(long questionId, String userAnswer) {

        String correctAnswer = getCorrectAnswer(questionId);
        return correctAnswer.equalsIgnoreCase(userAnswer);

    }
}
