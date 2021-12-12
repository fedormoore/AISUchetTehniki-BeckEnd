package ru.moore.AISUchetTehniki.models.Dto.spr.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BudgetAccountResponseDto {

    private Long id;
    private String code;
    private String name;

}
