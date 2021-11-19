package ru.moore.AISUchetTehniki.models.Dto.spr.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModelResponseDto {

    private Long id;
    private String name;
    private DeviceTypeResponseDto deviceType;
    private FirmResponseDto firm;

}