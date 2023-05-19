package br.com.cod2d.consumer.gateway.impl.http;


import br.com.cod2d.consumer.config.client.gs1basic.Gs1BasicFeignClientConfig;
import br.com.cod2d.consumer.domain.dto.gs1.response.ResponseProductGS1;
import br.com.cod2d.consumer.domain.exceptions.Gs1ApiGatewayException;
import br.com.cod2d.consumer.gateway.Gs1ClientGateway;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static br.com.cod2d.consumer.usecase.utils.ConvertUtils.toJson;


@Slf4j
@Component
@RequiredArgsConstructor
public class Gs1ApiClientGatewayImpl implements Gs1ClientGateway {

    private final Gs1BasicFeignClientConfig api;

    public ResponseProductGS1 getGtin(final String post) {
        log.info("[Gs1ApiClientGatewayImpl] - run get gs1 {}", toJson(post));
        try {
            return this.api.getGtin(post);
        } catch (final FeignException ex) {
            log.error("Error run GS1 Gateway");
            throw new Gs1ApiGatewayException(ex.getMessage());
        }
    }

}
