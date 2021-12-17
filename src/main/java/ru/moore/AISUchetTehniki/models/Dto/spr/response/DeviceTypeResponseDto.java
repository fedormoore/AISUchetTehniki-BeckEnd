package ru.moore.AISUchetTehniki.models.Dto.spr.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceTypeResponseDto {

    private Long id;
    private String name;
    private String level;

}
