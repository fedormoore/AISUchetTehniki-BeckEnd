package ru.moore.AISUchetTehniki.models.Dto.spr.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.moore.AISUchetTehniki.models.Dto.spr.OrganizationDto;

@Data
@NoArgsConstructor
public class BudgetAccountResponseDto {

    private Long id;
    private String code;
    private String name;

}
