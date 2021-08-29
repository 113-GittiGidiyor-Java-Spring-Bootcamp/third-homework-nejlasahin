package dev.patika.thirdhomework.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseName;

    private String courseCode;

    private int creditScore;

    @JsonIgnore
    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    private Instructor instructor;


}
