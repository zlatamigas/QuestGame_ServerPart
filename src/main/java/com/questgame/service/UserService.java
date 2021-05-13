package com.questgame.service;

import com.questgame.dto.UserDto;

public interface UserService {

    UserDto get(String name, String password);

    UserDto get(long id);

    int getScore(long id);

    void save(String name, String password);

    void updatePassword(long id, String password);

    void updateUserName(long id, String username);

    void updateScore(long id, int score);

    void delete(long id);

    boolean checkNameAccessibility(String name);


}
