package com.questgame.dao;

import com.questgame.dao.domain.Topic;

import java.util.List;

public interface TopicDao {

    List<Topic> getTopics();

    List<Topic> getNTopics(int n);

}
