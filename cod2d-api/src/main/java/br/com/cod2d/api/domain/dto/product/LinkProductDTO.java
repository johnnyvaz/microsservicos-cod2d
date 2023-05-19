package br.com.cod2d.api.domain.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinkProductDTO {

    @NotEmpty
    @JsonProperty("Gtin")
    @Schema(example = "7890000000000", description = "Código de Barras de EAN13")
    private String gtinEan; //01

    @Schema(example = "ABC1234", description = "Código de identificação do produtoDTO na empresa (SKU)")
    private String sku; //22

    @JsonProperty("codigoInterno")
    @Schema(example = "12345678", description = "Código interno da empresa (Referência)")
    private Long internalCode; //91

    @JsonProperty("dataProducao")
    @Schema(example = "221030", description = "Data de Produção no formato - Ano Mês Dia - 6 digitos ")
    private Long dateProduced; //11

    @JsonProperty("dataValidade")
    @Schema(example = "231030", description = "Data de Validade no formato - Ano Mês Dia - 6 digitos ")
    private Long dateExpired; //17

    @Schema(example = "000150", description = "Peso Líquido - o valor 000150 representa 0,150Kg")
    private Long pesoLiq; //3103

    @Schema(example = "5046", description = "Valor a Pagar - o valor 5046 representa R$ 50,46")
    private Long price; //3922

}