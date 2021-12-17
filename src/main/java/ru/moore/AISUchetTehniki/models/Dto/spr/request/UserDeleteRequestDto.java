package ru.moore.AISUchetTehniki.models.Dto.spr.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDeleteRequestDto {

    private Long id;
    private boolean deleted;

}
