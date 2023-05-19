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
public class ConsultaProdutosRequestDTO {

    @JsonProperty("Chave")
    private String chave;

    @JsonProperty("OrderReg")
    private String orderReg;

    @JsonProperty("FilterCategoria")
    private Integer filterCategoria;

    @JsonProperty("FilterEAN")
    private String filterEAN;

    @JsonProperty("FilterSKU")
    private String filterSKU;

    @JsonProperty("FilterMarca")
    private Integer filterMarca;

    @JsonProperty("DataAlteracaoApos")
    private String dataAlteracaoApos;

    @JsonProperty("DataAlteracaoAte")
    private String dataAlteracaoAte;

    @JsonProperty("ProdutoTipo")
    private Integer produtoTipo;

    @JsonProperty("NumPag")
    private Integer numPag;
}
