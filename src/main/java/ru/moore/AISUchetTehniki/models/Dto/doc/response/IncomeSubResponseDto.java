package ru.moore.AISUchetTehniki.models.Dto.doc.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.ModelResponseDto;

import java.util.List;

@Data
@NoArgsConstructor
public class IncomeSubResponseDto {

    private Long id;
    private ModelResponseDto model;
    private int count;
    private double sum;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IncomeSubResponseDto> children;

}
