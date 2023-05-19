package br.com.cod2d.consumer.domain.dto.gs1.response;

import br.com.cod2d.consumer.domain.enums.GtinStatusCodeEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductGS1 {

    private Gs1TradeItemIdentificationKeyDTO gs1TradeItemIdentificationKey;
    private TradeItemDescriptionInformationDTO tradeItemDescriptionInformation;
    private List<String> childTradeItems;
    private List<ReferencedFileInformationsDTO> referencedFileInformations;
    private GtinStatusCodeEnum gtinStatusCode;
    private BrandNameInformationDTO brandNameInformation;
    private String languageCode;
    private TradeItemWeightDTO tradeItemWeight;
    private TradeItemMeasurementsDTO tradeItemMeasurements;
    private TradeItemClassificationDTO tradeItemClassification;
    private String status;
    private String message;

}
