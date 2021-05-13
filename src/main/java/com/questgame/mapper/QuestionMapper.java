package com.questgame.mapper;

import com.questgame.dao.domain.Question;
import com.questgame.dto.QuestionDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class QuestionMapper {

    public static QuestionDto questionToDto(Question question) {
        return new QuestionDto(question.getId(), question.getText(), question.getTopic(), question.getDifficulty());
    }

}
