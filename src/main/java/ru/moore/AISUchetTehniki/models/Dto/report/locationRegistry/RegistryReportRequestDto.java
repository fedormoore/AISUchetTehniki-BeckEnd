package ru.moore.AISUchetTehniki.models.Dto.report.locationRegistry;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.ModelResponseDto;

import java.util.List;

@Data
@NoArgsConstructor
public class RegistryReportRequestDto {

    private Long id;
    private ModelResponseDto model;
    private String invNumber;
    private UserReportResponseDto user;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RegistryReportRequestDto> children;

}
