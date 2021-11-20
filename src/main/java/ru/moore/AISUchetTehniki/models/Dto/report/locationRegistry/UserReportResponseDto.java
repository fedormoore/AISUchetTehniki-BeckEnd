package ru.moore.AISUchetTehniki.models.Dto.report.locationRegistry;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.moore.AISUchetTehniki.models.Dto.spr.OrganizationDto;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.LocationResponseDto;

@Data
@NoArgsConstructor
public class UserReportResponseDto {

    private String lastName;
    private String firstName;
    private String middleNames;

}
