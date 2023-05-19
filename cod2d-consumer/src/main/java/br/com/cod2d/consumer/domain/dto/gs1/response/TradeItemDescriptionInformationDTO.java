package br.com.cod2d.consumer.domain.dto.gs1.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TradeItemDescriptionInformationDTO {

    private String tradeItemDescription;
    private String tradeItemDescriptionAdditional;
}
