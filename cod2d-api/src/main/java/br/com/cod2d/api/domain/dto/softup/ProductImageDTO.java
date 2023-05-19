package br.com.cod2d.api.domain.dto.softup;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageDTO {

    @JsonProperty("ProdutoImagemItem")
    private Long produtoImagemItem;

    @JsonProperty("ProdutoImagem")
    private String produtoImagem;

    @JsonProperty("ProdutoImagem_GXI")
    private String produtoImagemGXI;
}
