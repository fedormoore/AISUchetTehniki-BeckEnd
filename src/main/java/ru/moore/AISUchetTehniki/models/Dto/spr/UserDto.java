package ru.moore.AISUchetTehniki.models.Dto.spr;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String lastName;
    private String firstName;
    private String middleNames;
    private LocationDto location;
    private String email;
    private String telephone;

    private OrganizationDto organization;

    private LocalDateTime createdAt;

}
