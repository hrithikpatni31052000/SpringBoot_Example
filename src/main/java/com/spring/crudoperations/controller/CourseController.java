package com.spring.crudoperations.controller;

import com.spring.crudoperations.model.Course;
import com.spring.crudoperations.service.CourseService;
import com.spring.crudoperations.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@RestController
public class CourseController
{
    @Autowired
    private CourseService courseService;

    Logger logger = Logger.getLogger(CourseController.class);

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id)
    {
        return courseService.getAllCourses(id);
    }


    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id)
    {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course , @PathVariable String topicId)
    {
        course.setTopic(new Topic(topicId , "" ,""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id ,@PathVariable String topicId)
    {
        course.setTopic(new Topic(topicId , "" ,""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id)
    {
        courseService.deleteCourse(id);
    }
}
