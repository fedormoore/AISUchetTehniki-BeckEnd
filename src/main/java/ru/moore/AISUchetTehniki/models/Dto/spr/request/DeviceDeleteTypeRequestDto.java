package ru.moore.AISUchetTehniki.models.Dto.spr.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceDeleteTypeRequestDto {

    private Long id;
    private boolean deleted;

}
