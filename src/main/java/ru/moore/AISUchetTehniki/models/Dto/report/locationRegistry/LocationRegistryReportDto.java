package ru.moore.AISUchetTehniki.models.Dto.report.locationRegistry;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LocationRegistryReportDto {

    private String name;

    private List<RegistryReportRequestDto> registries;
}
