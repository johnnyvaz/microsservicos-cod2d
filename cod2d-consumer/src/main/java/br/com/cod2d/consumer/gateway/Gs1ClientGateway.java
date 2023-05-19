package br.com.cod2d.consumer.gateway;

import br.com.cod2d.consumer.domain.dto.gs1.response.ResponseProductGS1;

public interface Gs1ClientGateway {

    ResponseProductGS1 getGtin(final String get);

}
