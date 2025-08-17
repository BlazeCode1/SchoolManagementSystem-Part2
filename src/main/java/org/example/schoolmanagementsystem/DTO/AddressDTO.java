package org.example.schoolmanagementsystem.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    @NotNull(message = "Teacher Id cannot be null")
    private Integer teacher_id;

    @NotEmpty(message = "Area Cannot Be Empty")
    private String area;

    @NotEmpty(message = "street Cannot Be Empty")
    private String street;

    @NotEmpty(message = "building Number Cannot Be Empty Cannot Be Empty")
    private String buildingNumber;
}
