package br.com.cod2d.api.domain.dto.softup;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {

    @JsonProperty("ProdutoCodigo")
    private Long produtoCodigo;
    @JsonProperty("ProdutoTipo")
    private Long produtoTipo;
    @JsonProperty("ProdutoCodigoEAN")
    private String produtoCodigoEAN;
    @JsonProperty("TGruposProdutosCodigo")
    private Integer tGruposProdutosCodigo;
    @JsonProperty("ProdutoDescricao")
    private String produtoDescricao;
    @JsonProperty("ProdutoUND")
    private String produtoUND;
    @JsonProperty("NCM")
    private String nCM;
    @JsonProperty("ProdutoValorCompra")
    private float produtoValorCompra;
    @JsonProperty("ProdutoPerLucro")
    private float produtoPerLucro;
    @JsonProperty("ProdutoValorVenda")
    private float produtoValorVenda;
    @JsonProperty("ProdutoPesoLiq")
    private float produtoPesoLiq;
    @JsonProperty("ProdutoPesoBruto")
    private float produtoPesoBruto;
    @JsonProperty("ProdutoAtivo")
    private String produtoAtivo;
    @JsonProperty("ProdutoObs")
    private String produtoObs;
    @JsonProperty("ProdutoOcultarPDV")
    private String produtoOcultarPDV;
    @JsonProperty("ProdutoEstoque")
    private float produtoEstoque;
    @JsonProperty("ProdutoReferencia")
    private String produtoReferencia;
    @JsonProperty("ProdutoMLTitAnuncio")
    private String produtoMLTitAnuncio;
    @JsonProperty("ProdutoDescricaoCompleta")
    private String produtoDescricaoCompleta;
    @JsonProperty("ProdutoComprimento")
    private float produtoComprimento;
    @JsonProperty("ProdutoLargura")
    private float produtoLargura;
    @JsonProperty("ProdutoAltura")
    private float produtoAltura;
    @JsonProperty("TMarcasCodigo")
    private String tMarcasCodigo;
    @JsonProperty("ProdutoURLVideo")
    private String produtoURLVideo;
    @JsonProperty("ProdutoRetiraLocal")
    private String produtoRetiraLocal;
    @JsonProperty("ProdutoNovoUsado")
    private String produtoNovoUsado;
    @JsonProperty("ProdutoValorVendaECommerce")
    private float produtoValorVendaECommerce;
    @JsonProperty("ProdutoDescricaoGarantia")
    private String produtoDescricaoGarantia;
    @JsonProperty("ProdutoFreteGratis")
    private String produtoFreteGratis;
    @JsonProperty("ProdutoTagTitle")
    private String produtoTagTitle;
    @JsonProperty("ProdutoMetaTagDescription")
    private String produtoMetaTagDescription;
    @JsonProperty("ProdutoMetaTagKeywords")
    private String produtoMetaTagKeywords;
    @JsonProperty("ProdutoFornecedor")
    private String produtoFornecedor;
    @JsonProperty("ProdutoIdEcommerce")
    private String produtoIdEcommerce;
    @JsonProperty("ProdutoInativarVitrine")
    private String produtoInativarVitrine;

    @JsonProperty("ProdutoImagem")
    private List<ProductImageDTO> produtoImagem;

    @JsonProperty("Variacoes")
    private List<ProductVariacoesDTO> variacoes;
}
