package dev.patika.thirdhomework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SuperBuilder
public class VisitingResearcher extends Instructor{

    private double hourlySalary;

}