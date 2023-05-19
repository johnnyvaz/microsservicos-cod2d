package br.com.cod2d.consumer.domain.dto.gs1.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandNameInformationDTO {

    @JsonCreator
    public BrandNameInformationDTO(@JsonProperty("brandName") final String brandName) {
        this.brandName = brandName;
    }

    private String brandName;
}
