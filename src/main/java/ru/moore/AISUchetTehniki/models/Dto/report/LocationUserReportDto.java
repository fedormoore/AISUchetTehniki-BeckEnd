package ru.moore.AISUchetTehniki.models.Dto.report;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LocationUserReportDto {

    private Long id;
    private String type;
    private String name;

    private List<UserReportDto> user;
}
