package dev.patika.thirdhomework.controller;

import dev.patika.thirdhomework.dao.CourseDAO;
import dev.patika.thirdhomework.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseDAO courseDAO;

    @GetMapping("/courses")
    public List<Course> findAll(){
        return (List<Course>) courseDAO.findAll();
    }

    @GetMapping("/courses/{id}")
    public Optional<Course> findById(@PathVariable int id){
        return courseDAO.findById(id);
    }

    @PostMapping("/courses")
    public void saveCourse(@RequestBody Course course){
        courseDAO.save(course);
    }

    @PutMapping("/courses")
    public void updateCourse(@RequestBody Course course){
        courseDAO.save(course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable int id){
        courseDAO.deleteById(id);
    }
}
