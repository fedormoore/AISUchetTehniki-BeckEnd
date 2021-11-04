package ru.moore.AISUchetTehniki.models.Dto.spr;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class LocationDto {

    private Long id;
    private String type;
    private String name;

    private LocationParentDto parent;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocationDto> child;

    private LocalDateTime createdAt;

}
