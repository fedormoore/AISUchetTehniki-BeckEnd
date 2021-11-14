package ru.moore.AISUchetTehniki.models.Dto.doc.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.moore.AISUchetTehniki.models.Dto.doc.response.IncomeSubResponseDto;
import ru.moore.AISUchetTehniki.models.Dto.spr.response.CounterpartyResponseDto;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class IncomeMainRequestDto {

    private Long id;
    private Boolean executed;
    private Date dataExecuted;

    private String numberDoc;
    private Date dataDoc;

    private double sumCon;
    private Date dataCon;
    private String numberCon;

    private CounterpartyResponseDto counterparty;

    private List<IncomeSubRequestDto> docSubs;

}
