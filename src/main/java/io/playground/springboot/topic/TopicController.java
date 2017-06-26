package io.playground.springboot.topic;

import io.playground.springboot.topic.pojo.Topic;
import io.playground.springboot.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

  private final String TOPICS = "/topics";
  private final String TOPICS_ID_PATH = TOPICS + "/{id}";
  private TopicService topicService;

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
