package br.com.cod2d.api.domain.dto.softup;

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
public class RequestIntegracaoProdutosDTO {

    @NotEmpty
    @Schema(example = "asdfsdfhfghjghjk356eg4g4", description = "Chave de acesso ao sistema SoftUp")
    @JsonProperty("ChaveSoftup")
    private String chave;

    @Schema(example = "abc", description = "Caso não seja preenchido o sistema fará a " +
            "integração de todos os produtoDTOS, conforme o cadastro no Sistema Gestão Online")
    @JsonProperty("FiltrarCategoria")
    private Integer filterCategoria;

    @Schema(example = "3", description = "Verifique quantas paginas possui " +
            "de cadastrado de produtoDTO e coloque o total")
    @JsonProperty("Paginas")
    private Integer pagesProducts;

    @JsonProperty("FiltrarEAN")
    private String filterEAN;

    @JsonProperty("FiltrarSKU")
    private String filterSKU;

    @JsonProperty("FiltrarMarca")
    private Integer filterMarca;

}
