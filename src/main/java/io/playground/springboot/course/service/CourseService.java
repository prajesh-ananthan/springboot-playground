package io.playground.springboot.course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.playground.springboot.course.pojo.Course;

@Service
public interface CourseService {

  List<Course> getAllCourses(String topicId);

  Course findCourseById(String id);

  void addCourse(Course topic);

  void updateCourse(Course topic);

  void deleteCourse(String id);

}
