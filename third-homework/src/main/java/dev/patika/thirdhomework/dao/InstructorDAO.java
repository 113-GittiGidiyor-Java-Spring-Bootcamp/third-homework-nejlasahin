package dev.patika.thirdhomework.dao;

import dev.patika.thirdhomework.model.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface InstructorDAO extends CrudRepository<Instructor, Integer> {
}
