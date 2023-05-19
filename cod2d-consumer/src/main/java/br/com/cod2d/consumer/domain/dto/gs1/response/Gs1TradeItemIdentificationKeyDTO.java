package br.com.cod2d.consumer.domain.dto.gs1.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Gs1TradeItemIdentificationKeyDTO {

    private String gs1TradeItemIdentificationKeyCode;
    private String gtin;
    private String fixedLengthGtin;
}
