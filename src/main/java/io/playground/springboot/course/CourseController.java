package io.playground.springboot.course;

import io.playground.springboot.course.pojo.Course;
import io.playground.springboot.course.service.CourseService;
import io.playground.springboot.topic.pojo.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

  private final String COURSES_PATH = "/courses/{id}";
  private final String TOPIC_PATH = "/topics/{topicId}";
  private final String ERROR_MSG = "404: No page found with this URL";
  private CourseService courseService;

  @RequestMapping(method = RequestMethod.GET, value = TOPIC_PATH + "/courses")
  public List<Course> getAllCourses(@PathVariable("topicId") String topicId) {
    return courseService.getAllCourses(topicId);
  }


  @RequestMapping(method = RequestMethod.GET, value = TOPIC_PATH + COURSES_PATH)
  public Course getCourse(@PathVariable("id") String id) {
    return courseService.findCourseById(id);
  }


  @RequestMapping(method = RequestMethod.POST, value = TOPIC_PATH + "/courses")
  public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
    course.setTopic(new Topic(topicId, "", ""));
    courseService.addCourse(course);
  }


  @RequestMapping(method = RequestMethod.PUT, value = TOPIC_PATH + COURSES_PATH)
  public void updateCourse(@RequestBody Course course, @PathVariable String topicId,
                           @PathVariable String id) {
    course.setTopic(new Topic(topicId, "", ""));
    courseService.updateCourse(course);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = TOPIC_PATH + COURSES_PATH)
  public void deleteCourse(@RequestBody Course course, @PathVariable String id) {
    courseService.deleteCourse(id);
  }

  @RequestMapping("*")
  @ResponseBody
  public String fallbackMethod() {
    return ERROR_MSG;
  }

  public CourseService getCourseService() {
    return courseService;
  }

  @Autowired
  public void setCourseService(CourseService courseService) {
    this.courseService = courseService;
  }

}
