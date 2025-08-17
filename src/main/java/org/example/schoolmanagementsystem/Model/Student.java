package org.example.schoolmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Student Name Cannot Be Empty")
    @Column(nullable = false)
    private String name;
    @NotNull(message = "Student age is Required!")
    @Column(nullable = false)
    private Integer age;

    @NotEmpty(message = "Student Major is Required!")
    private String major;

    @ManyToMany
    @JsonIgnore
    private Set<Course> course;
}
