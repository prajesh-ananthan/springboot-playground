package io.playground.springboot.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.playground.springboot.course.dao.CourseDao;
import io.playground.springboot.course.pojo.Course;

@Service
public class CourseServiceImpl implements CourseService {

  @Autowired
  CourseDao courseDao;

  @Override
  public Course findCourseById(String id) {
    return courseDao.findOne(id);
  }

  @Override
  public void addCourse(Course course) {
    courseDao.save(course);
  }

  @Override
  public void updateCourse(Course course) {
    courseDao.save(course);
  }

  public List<Course> getAllCourses(String topicId) {
    List<Course> courses = new ArrayList<Course>();
    courseDao.findByTopicId(topicId)
    .forEach(courses::add);
    return courses;
  }

  @Override
  public void deleteCourse(String id) {
    courseDao.delete(id);
  }
}
