package ru.moore.AISUchetTehniki.models.Dto.spr.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.moore.AISUchetTehniki.models.Dto.spr.request.DeviceTypeRequestDto;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.FirmResponseDto;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ModelResponseDto {

    private Long id;
    private String name;
    private DeviceTypeRequestDto deviceType;

}