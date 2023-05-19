package br.com.cod2d.consumer.domain.dto.gs1.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TradeItemMeasurementsDTO {

    private NetContentDTO netContent;
    private HeightDTO height;
    private WidthDTO width;
    private DepthDTO depth;

}
