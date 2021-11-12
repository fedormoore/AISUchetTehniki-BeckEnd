package ru.moore.AISUchetTehniki.models.Dto.report;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.LocationResponseDto;

@Data
@NoArgsConstructor
public class UserReportDto {

    private Long id;
    private String lastName;
    private String firstName;
    private String middleNames;
    private LocationResponseDto location;
    private String email;
    private String telephone;

}
