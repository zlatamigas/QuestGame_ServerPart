package com.questgame.service.impl;

import com.questgame.dao.impl.DifficultyDaoImpl;
import com.questgame.dto.DifficultyDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DifficultyServiceImplTest {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private DifficultyServiceImpl difficultyService;

    @Test
    void getDifficulties() {

        difficultyService = new DifficultyServiceImpl(new DifficultyDaoImpl(jdbcTemplate));

        List<DifficultyDto> expectedResult = new ArrayList<DifficultyDto>();
        List<DifficultyDto> actualResult = difficultyService.getDifficulties();

        expectedResult.add(new DifficultyDto(1, 100));
        expectedResult.add(new DifficultyDto(2, 200));
        expectedResult.add(new DifficultyDto(3, 300));
        expectedResult.add(new DifficultyDto(4, 400));
        expectedResult.add(new DifficultyDto(5, 500));

        assertEquals(expectedResult, actualResult);
    }
}