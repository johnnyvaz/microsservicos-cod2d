package br.com.cod2d.api.usecase;

import br.com.cod2d.api.domain.dto.product.RequestProductGtinDTO;
import br.com.cod2d.api.domain.dto.product.ResponseProductGtinDTO;

public interface ProductGtinUseCase {

    ResponseProductGtinDTO sendGtin(final RequestProductGtinDTO product,
                                        final String organizationUuid) throws Exception;
}
