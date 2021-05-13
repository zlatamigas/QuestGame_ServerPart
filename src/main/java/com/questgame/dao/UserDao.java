package com.questgame.dao;

import com.questgame.dao.domain.User;

public interface UserDao {

    User get(String name, String password);

    User get(long id);

    int getScore(long id);

    void save(String name, String password);

    void updatePassword(long id, String password);

    void updateUserName(long id, String username);

    void updateScore(long id, int score);

    void delete(long id);

    boolean checkName(String name);
}
