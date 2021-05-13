package com.questgame.dao.impl;

import com.questgame.dao.UserDao;
import com.questgame.dao.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public User get(String name, String password) {

        Map<String, Object> sqlInsertParametersMap = new HashMap<String, Object>();
        sqlInsertParametersMap.put("name", name);
        sqlInsertParametersMap.put("password", password);
        try {
            return jdbcTemplate.queryForObject("select * from game_user where name=:name and password=:password", sqlInsertParametersMap, (resultSet, rowNum) ->
                    new User(resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getString("password").toCharArray(),
                            resultSet.getInt("score")));
        } catch (DataAccessException dae) {
            return null;
        }

    }

    @Override
    public User get(long id) {

        Map<String, Object> sqlInsertParametersMap = new HashMap<String, Object>();
        sqlInsertParametersMap.put("id", id);
        try {
            return jdbcTemplate.queryForObject("select * from game_user where id=:id", sqlInsertParametersMap, (resultSet, rowNum) ->
                    new User(resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getString("password").toCharArray(),
                            resultSet.getInt("score")));
        } catch (DataAccessException dae) {
            return null;
        }
    }

    @Override
    public int getScore(long id) {

        Map<String, Object> sqlInsertParametersMap = new HashMap<String, Object>();
        sqlInsertParametersMap.put("id", id);
        try {
            return jdbcTemplate.queryForObject("select score from game_user where id=:id", sqlInsertParametersMap, (resultSet, rowNum) ->
                    new Integer(resultSet.getInt("score")));
        } catch (DataAccessException dae) {
            return -1;
        }
    }

    @Override
    public void save(String name, String password) {

        Map<String, Object> sqlInsertParametersMap = new HashMap<String, Object>();
        sqlInsertParametersMap.put("name", name);
        sqlInsertParametersMap.put("password", password);
        jdbcTemplate.update("insert into game_user (name,password) values (:name,:password)", sqlInsertParametersMap);

    }

    @Override
    public void updatePassword(long id, String password) {

        Map<String, Object> sqlInsertParametersMap = new HashMap<String, Object>();
        sqlInsertParametersMap.put("id", id);
        sqlInsertParametersMap.put("password", password);
        jdbcTemplate.update("update game_user set password=:password where id=:id", sqlInsertParametersMap);

    }

    @Override
    public void updateUserName(long id, String username) {

        Map<String, Object> sqlInsertParametersMap = new HashMap<String, Object>();
        sqlInsertParametersMap.put("id", id);
        sqlInsertParametersMap.put("name", username);
        jdbcTemplate.update("update game_user set name=:name where id=:id", sqlInsertParametersMap);

    }

    @Override
    public void updateScore(long id, int score) {

        Map<String, Object> sqlInsertParametersMap = new HashMap<String, Object>();
        sqlInsertParametersMap.put("id", id);
        sqlInsertParametersMap.put("score", score);
        jdbcTemplate.update("update game_user set score=:score where id=:id", sqlInsertParametersMap);

    }

    @Override
    public void delete(long id) {

        Map<String, Object> sqlInsertParametersMap = new HashMap<String, Object>();
        sqlInsertParametersMap.put("id", id);
        jdbcTemplate.update("delete from game_user where id=:id", sqlInsertParametersMap);

    }

    @Override
    public boolean checkName(String name) {
        Map<String, Object> sqlInsertParametersMap = new HashMap<String, Object>();
        sqlInsertParametersMap.put("name", name);
        try {
            return jdbcTemplate.queryForObject("select * from game_user where name=:name", sqlInsertParametersMap, (resultSet, rowNum) ->
                    resultSet.first());
        } catch (DataAccessException dae) {
            return true;
        }
    }
}
