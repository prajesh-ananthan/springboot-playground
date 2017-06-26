package io.playground.springboot.topic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.playground.springboot.topic.dao.TopicDao;
import io.playground.springboot.topic.pojo.Topic;

@Service
public interface TopicService {

  List<Topic> getAllTopics();

  Topic findTopicById(String id);

  void addTopic(Topic topic);

  void updateTopic(Topic topic);

  List<Topic> buildContent();
}
