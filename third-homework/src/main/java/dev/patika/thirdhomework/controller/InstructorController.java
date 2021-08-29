package dev.patika.thirdhomework.controller;

import dev.patika.thirdhomework.dao.InstructorDAO;
import dev.patika.thirdhomework.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    @Autowired
    private InstructorDAO instructorDAO;

    @GetMapping("/instructors")
    public List<Instructor> findAll(){
        return (List<Instructor>) instructorDAO.findAll();
    }
}
