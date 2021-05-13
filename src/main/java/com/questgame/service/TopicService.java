package com.questgame.service;

import com.questgame.dto.TopicDto;

import java.util.List;

public interface TopicService {

    List<TopicDto> getTopics();

    List<TopicDto> getNTopics(int n);
}
