package ru.moore.AISUchetTehniki.models.Dto.spr.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.moore.AISUchetTehniki.models.Dto.spr.OrganizationDto;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.LocationResponseDto;
import ru.moore.AISUchetTehniki.models.Entity.spr.Location;
import ru.moore.AISUchetTehniki.models.Entity.spr.Organization;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class UserRequestDto {

    private Long id;

    @NotBlank(message = "Фамилия не может быть пустой")
    private String lastName;

    @NotBlank(message = "Имя не может быть пустым")
    private String firstName;

    private String middleNames;

    private LocationResponseDto location;

    @Email(message = "Некорректный E-mail")
    @NotBlank(message = "E-mail не может быть пустым")
    private String email;

    private String telephone;

    private Organization organization;

}
