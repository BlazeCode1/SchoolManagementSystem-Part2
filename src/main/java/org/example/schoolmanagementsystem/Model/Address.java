package org.example.schoolmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private Integer id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String area;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String street;


    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
