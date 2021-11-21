package ru.moore.AISUchetTehniki.models.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.BudgetAccountResponseDto;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.LocationResponseDto;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.ModelResponseDto;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.UserResponseDto;

import java.util.List;

@Data
@NoArgsConstructor
public class RegistryResponseDto {

    private Long id;
    private ModelResponseDto model;
    private String invNumber;
    private LocationResponseDto location;
    private UserResponseDto user;
    private BudgetAccountResponseDto budgetAccount;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RegistryResponseDto> children;

}
