package dev.patika.thirdhomework.controller;

import dev.patika.thirdhomework.service.CourseService;
import dev.patika.thirdhomework.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAllCourse(){
        return new ResponseEntity<>(courseService.findAllCourse(), HttpStatus.OK);
    }

    @GetMapping("/courses/id/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id){
        Optional<Course> resultOptional = courseService.findByCourseId(id);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/courses/courseName/{courseName}")
    public ResponseEntity<Course> findByCourseName(@PathVariable String courseName){
        Optional<Course> resultOptional = courseService.findByCourseName(courseName);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
