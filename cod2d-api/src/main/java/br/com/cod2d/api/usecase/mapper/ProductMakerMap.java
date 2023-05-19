package br.com.cod2d.api.usecase.mapper;

import br.com.cod2d.api.domain.dto.maker.PostMakerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductMakerMap {

    public PostMakerDTO toMaker(final UUID uuid) {
        return PostMakerDTO.builder()
                .productUuid(uuid)
                .build();
    }


}
