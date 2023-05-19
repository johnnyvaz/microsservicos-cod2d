package br.com.cod2d.api.usecase;

import br.com.cod2d.api.domain.dto.gs1.RequestGs1ProductDTO;

public interface Gs1ProductUseCase {

    Boolean send(final RequestGs1ProductDTO gtin,
                            final String organizationUuid) throws Exception;
}
