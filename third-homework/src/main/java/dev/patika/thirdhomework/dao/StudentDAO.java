package dev.patika.thirdhomework.dao;

import dev.patika.thirdhomework.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO extends CrudRepository<Student, Integer> {
}
