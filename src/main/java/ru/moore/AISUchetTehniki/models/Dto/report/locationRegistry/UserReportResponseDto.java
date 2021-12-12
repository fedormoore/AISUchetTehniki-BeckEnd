package ru.moore.AISUchetTehniki.models.Dto.report.locationRegistry;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserReportResponseDto {

    private String lastName;
    private String firstName;
    private String middleNames;

}
