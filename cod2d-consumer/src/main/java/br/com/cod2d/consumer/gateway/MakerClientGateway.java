package br.com.cod2d.consumer.gateway;

import br.com.cod2d.consumer.domain.dto.maker.PostMakerDTO;

public interface MakerClientGateway {

    String postMaker(final PostMakerDTO post);

}
