package br.com.cod2d.consumer.domain.dto.gs1.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TradeItemClassificationDTO {

    private String gpcCategoryCode;
    private List<AdditionalTradeItemClassificationsDTO> additionalTradeItemClassifications;
    private String gpcCategoryName;


}
