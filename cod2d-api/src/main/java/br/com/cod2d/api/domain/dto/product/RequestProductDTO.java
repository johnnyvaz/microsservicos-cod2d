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
public class RequestProductDTO {

    @JsonProperty("descricao")
    @Schema(example = "Nome do ProdutoDTO", description = "Um descrição objetiva, geralmente menos de uma linha")
    private String description;


    @Schema(example = "unidade", description = "Unidade de Medida (PR, UN, LT)")
    private String unidade;

    @Schema(example = "0000.00.00", description = "Nomenclatura Comum do Mercosul(8 dígitos)")
    private String ncm;

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