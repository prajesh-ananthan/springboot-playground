package io.playground.springboot.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.playground.springboot.topic.pojo.Topic;
import io.playground.springboot.topic.service.TopicService;

@RestController
public class TopicController {

  private TopicService topicService;

  private final String TOPICS = "/topics";
  private final String TOPICS_ID_PATH = TOPICS + "/{id}";

  @RequestMapping(value = TOPICS)
  public List<Topic> getTopics() {
    return topicService.getAllTopics();
  }

  @RequestMapping(method = RequestMethod.GET, value = TOPICS_ID_PATH)
  public Topic getId(@PathVariable("id") String id) {
    return topicService.findTopicById(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = TOPICS)
  public void addTopic(@RequestBody Topic topic) {
    topicService.addTopic(topic);
  }

  @RequestMapping(method = RequestMethod.PUT, value = TOPICS)
  public void updateTopic(@RequestBody Topic topic) {
    topicService.updateTopic(topic);
  }

  @RequestMapping(method = RequestMethod.POST, value = TOPICS + "/add")
  public List<Topic> addContent() {
    return topicService.buildContent();
  }

  public TopicService getTopicService() {
    return topicService;
  }

  @Autowired
  public void setTopicService(TopicService topicService) {
    this.topicService = topicService;
  }
}
