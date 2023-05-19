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
public class AtualizaProdutosRequestDTO {

    @JsonProperty("ItemProdutosUPD")
    private ItemProdutosUpdDTO itemProdutosUpdDTO;
}
