package dev.patika.thirdhomework.service;

import dev.patika.thirdhomework.dao.CourseDAO;
import dev.patika.thirdhomework.exceptions.BadRequestException;
import dev.patika.thirdhomework.model.Course;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Objects;
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

    public Course findByCourseName(String courseName){
        return courseDAO.findByCourseName(courseName);
    }

    public Course saveCourse(Course course) {
        return courseDAO.save(course);
    }
    public Course updateCourse(Course course) {
        Optional<Course> result = findByCourseId(course.getId());
        if(!result.isPresent()){
            throw new BadRequestException("Course not found.");
        }
        return courseDAO.save(course);
    }

    public void deleteCourse(int id) {
        Optional<Course> result = findByCourseId(id);
        if(!result.isPresent()){
            throw new BadRequestException("Course not found.");
        }
        courseDAO.deleteById(id);
    }

    public void deleteCourseName(String courseName) {
        Course result = findByCourseName(courseName);
        if(Objects.isNull(result)){
            throw new BadRequestException("Course not found.");
        }
        courseDAO.deleteById(result.getId());
    }
}
