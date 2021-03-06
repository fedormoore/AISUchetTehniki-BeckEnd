package ru.moore.AISUchetTehniki.models.Dto.spr;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class LocationParentDto {

    private Long id;
    private String type;
    private String name;

    private LocalDateTime createdAt;

}
