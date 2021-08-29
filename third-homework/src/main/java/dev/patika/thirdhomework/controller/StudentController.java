package dev.patika.thirdhomework.controller;

import dev.patika.thirdhomework.dao.StudentDAO;
import dev.patika.thirdhomework.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/students")
    public List<Student> findAll(){
        return (List<Student>) studentDAO.findAll();
    }

}
