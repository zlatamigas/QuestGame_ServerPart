package com.questgame.mapper;

import com.questgame.dao.domain.Topic;
import com.questgame.dto.TopicDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TopicMapper {

    public static TopicDto topicToDto(Topic topic) {
        return new TopicDto(topic.getId(), topic.getTopicName());
    }

}
