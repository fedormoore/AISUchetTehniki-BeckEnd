package ru.moore.AISUchetTehniki.models.Dto.spr.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LocationResponseDto {

    private Long id;
    private String type;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private LocationResponseDto parent;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocationResponseDto> children;

}
