package io.playground.springboot.topic.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.playground.springboot.topic.pojo.Topic;


@Repository
public interface TopicDao extends CrudRepository<Topic, String> {
  /**
   * 
   * We are able to to attain JPA operations
   * 
   */
}
