package br.com.cod2d.consumer.config.client.gs1basic;

import br.com.cod2d.consumer.domain.dto.gs1.response.ResponseProductGS1;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = Gs1BasicConfig.NAME, url = "${gs1.host}", configuration = {Gs1BasicConfig.class})
public interface Gs1BasicFeignClientConfig {

    @GetMapping(value = Gs1BasicConfig.GET_GTIN)
    ResponseProductGS1 getGtin(@PathVariable (name = "gtin") String gtin);

}
