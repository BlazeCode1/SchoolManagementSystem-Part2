package org.example.schoolmanagementsystem.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.annotations.Check;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Teacher Name Cannot Be Empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;


    @NotNull(message = "Teacher Age Cannot Be Empty")
    @PositiveOrZero(message = "Age Must be >= 0")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @Email(message = "Invalid Email.")
    @NotEmpty(message = "Teacher Email Cannot Be Empty")
    @Column(columnDefinition = "varchar(250) not null unique")
    private String email;

    @NotNull(message = "Teacher Salary Cannot Be Empty")
    @PositiveOrZero(message = "salary Must be >= 0")
    @Column(columnDefinition = "DOUBLE NOT NULL")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses;



}
