package br.com.cod2d.api.usecase;

import br.com.cod2d.api.domain.dto.UuidProductQueueDTO;
import br.com.cod2d.api.domain.model.Profile;
import br.com.cod2d.api.domain.model.ShortenerTag;

public interface ShortenerUseCase {

    ShortenerTag run(final UuidProductQueueDTO request, final Profile profile);

}
