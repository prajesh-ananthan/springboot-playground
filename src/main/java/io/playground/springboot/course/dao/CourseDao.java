package io.playground.springboot.course.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.playground.springboot.course.pojo.Course;


@Repository
public interface CourseDao extends CrudRepository<Course, String> {
  
  // Declare the method with this structure with Course property name
  List<Course> findByTopicId(String topicId);

}
