package ru.moore.AISUchetTehniki.models.Dto.spr;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ModelDto {

    private Long id;
    private String name;
    private FirmDto firm;
    private DeviceTypeDto deviceType;

    private LocalDateTime createdAt;

}