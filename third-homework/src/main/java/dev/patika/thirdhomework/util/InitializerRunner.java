package dev.patika.thirdhomework.util;

import dev.patika.thirdhomework.dao.CourseDAO;
import dev.patika.thirdhomework.dao.InstructorDAO;
import dev.patika.thirdhomework.dao.StudentDAO;
import dev.patika.thirdhomework.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InitializerRunner implements CommandLineRunner {

    @Autowired
    CourseDAO courseDAO;

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    InstructorDAO instructorDAO;

    @Override
    public void run(String... args) throws Exception {
        courseDAO.deleteAll();
        studentDAO.deleteAll();
        instructorDAO.deleteAll();

        Instructor instructor1 = PermanentInstructor.builder().name("Dulcie").address("46646 Bonner Street").phoneNumber("701-118-3088").fixedSalary(1111).build();
        Instructor instructor2 = PermanentInstructor.builder().name("Jan").address("9 Ilene Junction").phoneNumber("387-125-0540").fixedSalary(2222).build();
        Instructor instructor3 = VisitingResearcher.builder().name("Sergeant").address("77650 Division Pass").phoneNumber("417-288-5603").hourlySalary(3333).build();

        Course course1 = Course.builder().courseName("Java").courseCode("J101").creditScore(4).instructor(instructor1).build();
        Course course2 = Course.builder().courseName("C#").courseCode("C101").creditScore(3).instructor(instructor2).build();
        Course course3 = Course.builder().courseName("Php").courseCode("P101").creditScore(2).instructor(instructor3).build();

        List<Course> courses = new ArrayList<Course>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        Student student1 =Student.builder().name("Brant").birthDate(LocalDate.of(2000, 6, 25)).address("24468 Steensland Hill").gender('F').courseList(courses).build();
        Student student2=Student.builder().name("Margit").birthDate(LocalDate.of(1990, 3, 13)).address("87 Hermina Pass").gender('M').courseList(courses).build();
        Student student3=Student.builder().name("Filmer").birthDate(LocalDate.of(1995, 11, 2)).address("251 6th Terrace").gender('F').courseList(courses).build();

        instructorDAO.save(instructor1);
        instructorDAO.save(instructor2);
        instructorDAO.save(instructor3);

        courseDAO.save(course1);
        courseDAO.save(course2);
        courseDAO.save(course3);

        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

    }

}
