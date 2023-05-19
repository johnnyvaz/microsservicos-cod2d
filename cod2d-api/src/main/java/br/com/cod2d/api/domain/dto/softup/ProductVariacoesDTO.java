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
public class ProductVariacoesDTO {

    @JsonProperty("ProdutoVariacao")
    private String produtoVariacao;
    @JsonProperty("ProdutoVariacaoEstoque")
    private String produtoVariacaoEstoque;
    @JsonProperty("ProdutoVariacaoSKU")
    private String produtoVariacaoSKU;
    @JsonProperty("ProdutoVariacaoImg1")
    private String produtoVariacaoImg1;
    @JsonProperty("ProdutoVariacaoImg1_GXI")
    private String produtoVariacaoImg1_GXI;
    @JsonProperty("ProdutoVariacaoImg2")
    private String produtoVariacaoImg2;
    @JsonProperty("ProdutoVariacaoImg2_GXI")
    private String produtoVariacaoImg2_GXI;
    @JsonProperty("ProdutoVariacaoImg3")
    private String produtoVariacaoImg3;
    @JsonProperty("ProdutoVariacaoImg3_GXI")
    private String produtoVariacaoImg3_GXI;
    @JsonProperty("ProdutoVariacaoImg4")
    private String produtoVariacaoImg4;
    @JsonProperty("ProdutoVariacaoImg4_GXI")
    private String produtoVariacaoImg4_GXI;
    @JsonProperty("ProdutoVariacaoImg5")
    private String produtoVariacaoImg5;
    @JsonProperty("ProdutoVariacaoImg5_GXI")
    private String produtoVariacaoImg5_GXI;
}
