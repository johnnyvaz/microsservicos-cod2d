package br.com.cod2d.consumer.domain.dto.gs1.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class GrossWeightDTO {
    private String measurementUnitCode;
    private String value;
    private String originalValue;
}
