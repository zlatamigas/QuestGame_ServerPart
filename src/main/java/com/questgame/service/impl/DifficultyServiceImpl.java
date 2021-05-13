package com.questgame.service.impl;

import com.questgame.dao.DifficultyDao;
import com.questgame.dao.domain.Difficulty;
import com.questgame.dto.DifficultyDto;
import com.questgame.mapper.DifficultyMapper;
import com.questgame.service.DifficultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DifficultyServiceImpl implements DifficultyService {

    private final DifficultyDao difficultyDAO;

    @Override
    public List<DifficultyDto> getDifficulties() {

        List<DifficultyDto> difficultiesDto = new ArrayList<DifficultyDto>();
        List<Difficulty> difficulties = difficultyDAO.getDifficulties();

        if(difficulties == null)
            return null;

        for (Difficulty d : difficulties) {
            difficultiesDto.add(DifficultyMapper.difficultyToDto(d));
        }
        return difficultiesDto;
    }
}
