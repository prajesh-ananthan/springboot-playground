package io.playground.springboot.topic.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.playground.springboot.topic.dao.TopicDao;
import io.playground.springboot.topic.pojo.Topic;

@Service
public class TopicServiceImpl implements TopicService {
  private final List<Topic> topics = Arrays.asList(
      new Topic("1", "Java", "Java Programming"),
      new Topic("2", "Machine Learning", "Self learning robots"),
      new Topic("3", "Deep Learning", "Neural Networks"));

  @Autowired
  TopicDao topicDao;

  public List<Topic> getAllTopics() {
    List<Topic> topics = new ArrayList<Topic>();
    topicDao.findAll().forEach(topics::add);
    return topics;
  }

  public Topic findTopicById(String id) {
    return topicDao.findOne(id);
  }

  public void addTopic(Topic topic) {
    topicDao.save(topic);
  }

  public void updateTopic(Topic topic) {
    topicDao.save(topic);
  }

  public List<Topic> buildContent() {
    topicDao.save(topics);
    return getAllTopics();
  }
}
