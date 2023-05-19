package br.com.cod2d.consumer.domain.dto.gs1.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseProductGS1 {
    private ProductGS1 product;
    private String status;
    private String message;
}
