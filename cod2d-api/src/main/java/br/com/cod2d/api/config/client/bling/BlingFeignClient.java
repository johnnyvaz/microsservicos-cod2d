package br.com.cod2d.api.config.client.bling;

import br.com.cod2d.api.domain.dto.softup.ConsultaProdutosRequestDTO;
import br.com.cod2d.api.domain.dto.softup.ProductResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = Bling.NAME, url = "${api.bling.url}", configuration = {Bling.class})
public interface BlingFeignClient {

    @PostMapping(value = Bling.GET_PRODUCTS)
    List<ProductResponseDTO> getProduct(@RequestBody ConsultaProdutosRequestDTO consulta);

}
