package com.questgame.controller;

import com.google.gson.Gson;
//import com.questgame.dto.*;
//import com.questgame.service.impl.DifficultyServiceImpl;
//import com.questgame.service.impl.QuestionServiceImpl;
//import com.questgame.service.impl.TopicServiceImpl;
//import com.questgame.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;


@Controller
@RequiredArgsConstructor
@Slf4j
public class SocketController {

//    private final QuestionServiceImpl questionService;
//    private final UserServiceImpl userService;
//    private final TopicServiceImpl topicService;
//    private  final DifficultyServiceImpl difficultyService;


    @MessageMapping("/serverMessagePool")
    @SendTo("/topic/clientMessagePool")
    public Object replyMessage(String  JSONString) {
//    Gson gson = new Gson();
//    Map map = gson.fromJson(JSONString, Map.class);
//    String userName ;
//    String password ;
//    UserDto user;
//    int id;
//    MessageType messageType = MessageType.valueOf ((String)  map.get("messageType"));
//    switch (messageType){
//
//        case question:
//            QuestionQueryDto questionDtoQuery = gson.fromJson(JSONString, QuestionQueryDto.class);
//            return questionService.getRandomQuestion(
//                    questionDtoQuery.getTopic(),
//                    questionDtoQuery.getDifficulty());
//
//        case confirmation:
//            userName = (String) map.get("userName");
//            password = ((String) map.get("password"));
//            user = userService.get(userName,password);
//            boolean passwordIsValid = false;
//            id =-1;
//            if(user!=null) {
//                passwordIsValid = true;
//                id = (int) user.getId();
//            }
//
//            return new ConformationDto(passwordIsValid,id);
//
//        case user:
//            int userID = Math.toIntExact(Math.round((double) map.get("id")));
//            return userService.get(userID);
//
//        case createUser:
//            userName = (String) map.get("userName");
//            password = ((String) map.get("password"));
//            CreateUserResultDto result = new CreateUserResultDto(false,-1);
//            user = userService.get(userName,password);
//            if( user != null) {
//                result.setAlreadyExists(true);
//                result.setId((int) user.getId());
//            }
//            else {
//                userService.save(userName, password);
//                result.setId((int) userService.get(userName, password).getId());
//            }
//
//            return result;
//
//
//        case updateScore:
//            id = Math.toIntExact(Math.round((double) map.get("id")));
//            int score = Math.toIntExact(Math.round((double) map.get("score")));
//            userService.updateScore(id,score);
//            return new UpdateScoreResult(score);
//        case correctAnswer:
//            id = Math.toIntExact(Math.round((double) map.get("id")));
//            return new CorrectAnswerDto(questionService.getCorrectAnswer(id));
//
//        case topics:
//            int count = Math.toIntExact(Math.round((double) map.get("count")));
//            ArrayList<TopicDto> topicsFromDB = (ArrayList<TopicDto>) topicService.getNTopics(count);
//
//            String[] topics = new String[count];
//            for(int i = 0; i<count; i++)
//            {
//                topics[i] = topicsFromDB.get(i).getTopicName();
//            }
//            return  new TopicsDto(topics);
//
//
//        case difficulties:
//            int difficultiesCount = Math.toIntExact(Math.round((double) map.get("count")));
//            ArrayList<DifficultyDto> difficultiesFromDB = (ArrayList<DifficultyDto>) difficultyService.getDifficulties();
//
//            int[] difficulties = new int[difficultiesCount];
//            for(int i = 0; i<difficultiesCount; i++)
//            {
//                difficulties[i] = difficultiesFromDB.get(i).getPointsNumber();
//            }
//            return  new DifficultiesDto(difficulties);
//
//        default:
//            return null;
//    }

        return "Hi? it works! or not?";
    }
}