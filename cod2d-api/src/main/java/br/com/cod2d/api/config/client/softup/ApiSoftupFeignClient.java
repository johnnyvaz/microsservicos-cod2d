package br.com.cod2d.api.config.client.softup;

import br.com.cod2d.api.domain.dto.softup.AtualizaProdutosRequestDTO;
import br.com.cod2d.api.domain.dto.softup.ConsultaProdutosRequestDTO;
import br.com.cod2d.api.domain.dto.softup.ProductResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = ApiSoftup.NAME, url = "${api.softup.url}", configuration = {ApiSoftup.class})
public interface ApiSoftupFeignClient {

    @PostMapping(value = ApiSoftup.GET_PRODUCTS)
    List<ProductResponseDTO> getProduct(@RequestBody ConsultaProdutosRequestDTO consulta);

    @PostMapping(value = ApiSoftup.CHANGE_PRODUCTS)
    String changeProduct(@RequestBody AtualizaProdutosRequestDTO altera);

}
