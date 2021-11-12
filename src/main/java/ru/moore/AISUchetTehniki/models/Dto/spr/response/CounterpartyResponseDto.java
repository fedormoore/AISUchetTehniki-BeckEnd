package ru.moore.AISUchetTehniki.models.Dto.spr.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CounterpartyResponseDto {

    private Long id;
    private String name;
    private String inn;
    private String telephone;
    private String email;
    private String contact;

}
