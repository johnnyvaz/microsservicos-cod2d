package br.com.cod2d.consumer.domain.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String gtinEan; //01
    private String sku; //22

    @JsonProperty("codigoInterno")
    private Long internalCode; //91

    @JsonProperty("dataProducao")
    private Long dateProduced; //11

    @JsonProperty("dataValidade")
    private Long dateExpired; //17

    private Long pesoLiq; //3103

    private Long price; //3922

}