package dev.patika.thirdhomework.dao;

import dev.patika.thirdhomework.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends CrudRepository<Course, Integer> {
    Course findByCourseName(String courseName);

}
