package br.com.cod2d.consumer.domain.model.gtinbase;

import br.com.cod2d.consumer.domain.enums.GtinStatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gs1_products")
@DynamicInsert
@DynamicUpdate
public class ProductGS1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // gs1TradeItemIdentificationKey
    private String gs1TradeItemIdentificationKeyCode; // GTIN_13
    private String gtin; // 7896969208662
    private String fixedLengthGtin; // 07896969208662

    // TradeItemDescriptionInformationDTO
    private String tradeItemDescriptionInformation;
    private String tradeItemDescriptionInformationAdditional;

    private String tradeItemDescription; // ?
    private GtinStatusCodeEnum gtinStatusCode;
    private String brandNameInformation;

    private String languageCode;

//    private String additionalTradeItemDescription;

//    tradeItemWeight
    private String tradeItemWeightGrossWeightCode;
    private String tradeItemWeightGrossWeightValue;
    private String tradeItemWeightGrossWeightOriginalValueCode;
    private String tradeItemWeightNetWeightCode;
    private String tradeItemWeightNetWeightValue;

    // TradeItemMeasurements;
    private String tradeItemMeasurementsNetContentCode;
    private String tradeItemMeasurementsNetContentValue;
    private String tradeItemMeasurementsNetContentOriginalValue;

    private String tradeItemMeasurementsHeightCode;
    private String tradeItemMeasurementsHeightValue;
    private String tradeItemMeasurementsHeightOriginalValue;
    
    private String tradeItemMeasurementsWidthCode;
    private String tradeItemMeasurementsWidthValue;
    private String tradeItemMeasurementsWidthOriginalValue;
    
    private String tradeItemMeasurementsDepthCode;
    private String tradeItemMeasurementsDepthValue;
    private String tradeItemMeasurementsDepthOriginalValue;
    
    // TradeItemClassification;
    private String gpcCategoryCode;
    private String additionalTradeItemClassificationsCodeNCM;
    private String additionalTradeItemClassificationCodeCEST;
    private String gcpCategoryName;

    private String status;
    private String message;

}
