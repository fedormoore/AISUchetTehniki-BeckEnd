package ru.moore.AISUchetTehniki.models.Dto.spr.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.moore.AISUchetTehniki.models.Dto.spr.OrganizationDto;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.LocationResponseDto;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserResponseDto {

    private Long id;
    private String lastName;
    private String firstName;
    private String middleNames;
    private LocationResponseDto location;
    private String email;
    private String telephone;
    private OrganizationDto organization;

}
