package br.com.cod2d.consumer.domain.dto.gs1.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdditionalTradeItemClassificationsDTO {
    private String additionalTradeItemClassificationSystemCode;
    private String additionalTradeItemClassificationCodeValue;
}
