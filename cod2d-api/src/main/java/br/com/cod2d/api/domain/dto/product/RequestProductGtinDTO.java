package br.com.cod2d.api.domain.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestProductGtinDTO {

    @JsonProperty("gtin")
    @Schema(example = "7890000000000", description = "Código de Barras válido")
    private String gtin;

}