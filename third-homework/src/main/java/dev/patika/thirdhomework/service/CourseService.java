package dev.patika.thirdhomework.service;

import dev.patika.thirdhomework.dao.CourseDAO;
import dev.patika.thirdhomework.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseDAO courseDAO;

    public List<Course> findAllCourse(){
        return (List<Course>) courseDAO.findAll();
    }

    public Optional<Course> findByCourseId(int id){
        return courseDAO.findById(id);
    }

    public Optional<Course> findByCourseName(String courseName){
        return Optional.of(courseDAO.findByCourseName(courseName));
    }
}
