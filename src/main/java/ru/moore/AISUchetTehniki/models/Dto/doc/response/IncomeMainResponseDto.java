package ru.moore.AISUchetTehniki.models.Dto.doc.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.CounterpartyResponseDto;

import java.util.Date;

@Data
@NoArgsConstructor
public class IncomeMainResponseDto {

    private Long id;
    private Boolean executed;
    private Date dataExecuted;

    private String numberDoc;
    private Date dataDoc;

    private String sumCon;
    private Date dataCon;
    private String numberCon;

    private CounterpartyResponseDto counterparty;


}
