package com.questgame.mapper;

import com.questgame.dao.domain.Difficulty;
import com.questgame.dto.DifficultyDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DifficultyMapper {

    public static DifficultyDto difficultyToDto(Difficulty difficulty) {
        return new DifficultyDto(difficulty.getId(), difficulty.getPointsNumber());
    }

}
