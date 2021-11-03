package ru.moore.AISUchetTehniki.models.Dto.spr;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CounterpartyDto {

    private Long id;
    private String name;
    private Integer inn;
    private String telephone;
    private String mail;
    private String contact;

    private LocalDateTime createdAt;

}
