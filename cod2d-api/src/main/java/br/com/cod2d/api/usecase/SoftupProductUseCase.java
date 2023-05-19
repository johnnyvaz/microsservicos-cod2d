package br.com.cod2d.api.usecase;

import br.com.cod2d.api.domain.dto.softup.RequestIntegracaoProdutosDTO;

public interface SoftupProductUseCase {

    String run(final RequestIntegracaoProdutosDTO consulta, final String organizationUuid) throws Exception;
}
