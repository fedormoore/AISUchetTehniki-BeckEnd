package ru.moore.AISUchetTehniki.models.Dto.spr.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class ModelRequestDto {

    private Long id;

    @NotBlank(message = "Наименование не может быть пустым")
    private String name;

    private DeviceTypeRequestDto deviceType;

    private FirmRequestDto firm;

}