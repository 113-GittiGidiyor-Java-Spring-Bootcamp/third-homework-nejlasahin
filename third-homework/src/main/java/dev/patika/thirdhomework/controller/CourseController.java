package dev.patika.thirdhomework.controller;

import dev.patika.thirdhomework.service.CourseService;
import dev.patika.thirdhomework.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
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
        Course result = courseService.findByCourseName(courseName);
        if (!Objects.isNull(result)) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.OK);
    }

    @PutMapping("/courses")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.updateCourse(course), HttpStatus.OK);
    }

    @DeleteMapping("/courses/id/{id}")
    public void deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
    }

    @DeleteMapping("/courses/courseName/{courseName}")
    public void deleteCourse(@PathVariable String courseName){
        courseService.deleteCourseName(courseName);
    }




}
