package ru.moore.AISUchetTehniki.models.Dto.spr.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class LocationRequestDto {

    private Long id;
    @NotBlank(message = "Тип не может быть пустым")
    private String type;
    @NotBlank(message = "Наименование не может быть пустым")
    private String name;

    private LocationRequestDto parent;

}
