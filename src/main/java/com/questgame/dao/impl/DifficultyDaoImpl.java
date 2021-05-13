package com.questgame.dao.impl;

import com.questgame.dao.DifficultyDao;
import com.questgame.dao.domain.Difficulty;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DifficultyDaoImpl implements DifficultyDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Difficulty> getDifficulties() {
        try {
            return jdbcTemplate.query("SELECT * FROM difficulty", (resultSet, rowNum) ->
                    new Difficulty(resultSet.getLong("id"),
                            resultSet.getInt("score")));
        } catch (DataAccessException dae) {
            return null;
        }
    }
}
