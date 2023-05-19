package br.com.cod2d.api.domain.dto.gs1;

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
public class RequestGs1ProductDTO {

    @JsonProperty("gtin")
    @Schema(example = "7890000000000", description = "Código de Barras padrão EAN13 Válido")
    private String gtin;

}