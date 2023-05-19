package br.com.cod2d.consumer.usecase.mapper;

import br.com.cod2d.consumer.domain.dto.gs1.response.ResponseProductGS1;
import br.com.cod2d.consumer.domain.exceptions.ProductNotFoundException;
import br.com.cod2d.consumer.domain.model.gtinbase.ProductGS1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductGs1Map {

    public ProductGS1 toProductGs1(final ResponseProductGS1 dto) {

        if (dto.getProduct() == null) {
           throw new ProductNotFoundException();
        }


        return ProductGS1.builder()
                    .gs1TradeItemIdentificationKeyCode(dto.getProduct()
                            .getGs1TradeItemIdentificationKey().getGs1TradeItemIdentificationKeyCode())
                    .gtin(dto.getProduct()
                            .getGs1TradeItemIdentificationKey().getGtin())
                    .fixedLengthGtin(dto.getProduct()
                            .getGs1TradeItemIdentificationKey().getFixedLengthGtin())
                    .tradeItemDescriptionInformation(dto.getProduct().getTradeItemDescriptionInformation() != null ?
                            dto.getProduct().getTradeItemDescriptionInformation().getTradeItemDescription() : null)
                    .tradeItemDescription(dto.getProduct()
                            .getTradeItemDescriptionInformation().getTradeItemDescriptionAdditional())
                    .gtinStatusCode(dto.getProduct().getGtinStatusCode())
                    .brandNameInformation(dto.getProduct()
                            .getBrandNameInformation().getBrandName())
                    .languageCode(dto.getProduct().getLanguageCode())
                    .tradeItemWeightGrossWeightCode(dto.getProduct()
                            .getTradeItemWeight().getGrossWeight().getMeasurementUnitCode())
                    .tradeItemWeightGrossWeightValue(dto.getProduct()
                            .getTradeItemWeight().getGrossWeight().getValue())
                    .tradeItemWeightGrossWeightOriginalValueCode(dto.getProduct()
                            .getTradeItemWeight().getGrossWeight().getOriginalValue())
                    .tradeItemWeightNetWeightCode(dto.getProduct()
                            .getTradeItemWeight().getNetWeight().getMeasurementUnitCode())
                    .tradeItemWeightNetWeightValue(dto.getProduct()
                            .getTradeItemWeight().getNetWeight().getValue())

                    .tradeItemMeasurementsNetContentCode(dto.getProduct()
                            .getTradeItemMeasurements().getNetContent().getMeasurementUnitCode())
                    .tradeItemMeasurementsNetContentValue(dto.getProduct()
                            .getTradeItemMeasurements().getNetContent().getValue())
                    .tradeItemMeasurementsNetContentOriginalValue(dto.getProduct()
                            .getTradeItemMeasurements().getNetContent().getOriginalValue())
                    .tradeItemMeasurementsHeightCode(dto.getProduct()
                            .getTradeItemMeasurements().getHeight().getMeasurementUnitCode())
                    .tradeItemMeasurementsHeightValue(dto.getProduct()
                            .getTradeItemMeasurements().getHeight().getValue())
                    .tradeItemMeasurementsHeightOriginalValue(dto.getProduct()
                            .getTradeItemMeasurements().getHeight().getOriginalValue())

                    .tradeItemMeasurementsWidthCode(dto.getProduct()
                            .getTradeItemMeasurements().getWidth().getMeasurementUnitCode())
                    .tradeItemMeasurementsWidthValue(dto.getProduct()
                            .getTradeItemMeasurements().getWidth().getValue())
                    .tradeItemMeasurementsWidthOriginalValue(dto.getProduct()
                            .getTradeItemMeasurements().getWidth().getOriginalValue())

                    .tradeItemMeasurementsDepthCode(dto.getProduct()
                            .getTradeItemMeasurements().getDepth().getMeasurementUnitCode())
                    .tradeItemMeasurementsDepthValue(dto.getProduct()
                            .getTradeItemMeasurements().getDepth().getValue())
                    .tradeItemMeasurementsDepthOriginalValue(dto.getProduct()
                            .getTradeItemMeasurements().getDepth().getOriginalValue())

                    .gpcCategoryCode(dto.getProduct()
                            .getTradeItemClassification().getGpcCategoryCode())
//                    .additionalTradeItemClassificationsCodeNCM(
//                            dto.getProduct().getTradeItemClassification()
//                                    .getAdditionalTradeItemClassifications()
//                                    .stream().filter(additionalTradeItemClassificationsDTO -> "NCM" ))
//                    .additionalTradeItemClassificationCodeCEST(dto.getProduct().),
                    .gcpCategoryName(dto.getProduct().getTradeItemClassification().getGpcCategoryName())
                    .status(dto.getProduct().getStatus())
                    .message(dto.getProduct().getMessage())
                .build();
    }


}
