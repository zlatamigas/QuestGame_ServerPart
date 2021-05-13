package com.questgame.mapper;

import com.questgame.dao.domain.User;
import com.questgame.dto.UserDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static UserDto userToDto(User user) {
        if(user == null)
            return null;
        return new UserDto(user.getId(), user.getName(), user.getScore());
    }
}
