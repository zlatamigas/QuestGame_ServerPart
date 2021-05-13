package com.questgame.service.impl;

import com.questgame.dao.TopicDao;
import com.questgame.dao.domain.Topic;
import com.questgame.dto.TopicDto;
import com.questgame.mapper.TopicMapper;
import com.questgame.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicDao topicDAO;

    @Override
    public List<TopicDto> getTopics() {

        List<TopicDto> topicsDto = new ArrayList<TopicDto>();
        List<Topic> topics = topicDAO.getTopics();

        if(topics == null)
            return null;

        for (Topic t : topics) {
            topicsDto.add(TopicMapper.topicToDto(t));
        }
        return topicsDto;
    }

    @Override
    public List<TopicDto> getNTopics(int n) {

        List<TopicDto> topicsDto = new ArrayList<TopicDto>();
        List<Topic> topics = topicDAO.getNTopics(n);

        if(topics == null)
            return null;

        for (Topic t : topics) {
            topicsDto.add(TopicMapper.topicToDto(t));
        }
        return topicsDto;
    }

}
