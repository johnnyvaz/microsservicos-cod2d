package br.com.cod2d.api.gateway;

import br.com.cod2d.api.domain.dto.softup.AtualizaProdutosRequestDTO;
import br.com.cod2d.api.domain.dto.softup.ConsultaProdutosRequestDTO;
import br.com.cod2d.api.domain.dto.softup.ProductResponseDTO;

import java.util.List;

public interface SoftupClientGateway {

    List<ProductResponseDTO> getProduct(final ConsultaProdutosRequestDTO consulta);

    String changeProduct(final AtualizaProdutosRequestDTO altera);
}
