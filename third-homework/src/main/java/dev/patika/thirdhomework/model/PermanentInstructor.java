package dev.patika.thirdhomework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SuperBuilder
public class PermanentInstructor extends Instructor{

    private double fixedSalary;

}
