package br.com.cod2d.consumer.domain.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestProductDTO {

    @JsonProperty("descricao")
    private String description;

//    @JsonProperty("CodigoEmpresa")
//    @Schema(example = "00000000-0000-0000-0000-000000000000", description =
//    "Código único recebido no registro inicial")
//    private UUID organizationUuid;

    private String unidade;
    private String ncm;

//    @Schema(example = "1.00", description = "Peso Bruto")
//    private float pesoBruto;

    private String observacao;

    @JsonProperty("descricaoCompleta")
    private String fullDescription;

    @JsonProperty("comprimento")
    private Long length; //comprimento

    @JsonProperty("largura")
    private Long width; //largura

    @JsonProperty("altura")
    private Long height; //altura

    @JsonProperty("marca")
    private String brand; //marca

    private String URLVideo;
    private String URLProduto;
    private String URLInformacaoNutricional;
    private String tagTitle;
    private String metaTagDescription;
    private String metaTagKeywords;

    private LinkProductDTO linkProduct;

}