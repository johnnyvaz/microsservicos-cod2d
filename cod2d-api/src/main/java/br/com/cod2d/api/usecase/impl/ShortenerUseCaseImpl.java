package br.com.cod2d.api.usecase.impl;

import br.com.cod2d.api.domain.dto.UuidProductQueueDTO;
import br.com.cod2d.api.domain.enums.ShortLinkType;
import br.com.cod2d.api.domain.exception.NotifyExceptionEventDTO;
import br.com.cod2d.api.domain.model.Profile;
import br.com.cod2d.api.domain.model.ShortenerTag;
import br.com.cod2d.api.gateway.NotifyGateway;
import br.com.cod2d.api.gateway.impl.repository.jpa.ShortenerRepository;
import br.com.cod2d.api.usecase.ShortenerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShortenerUseCaseImpl implements ShortenerUseCase {

    private final NotifyGateway notifyGateway;
    private final ShortenerRepository shortenerRepository;


    @Override
    public ShortenerTag run(final UuidProductQueueDTO request,
                            final Profile profile) {
        try {
            log.info("gravando no banco");
            final ShortenerTag shortenerTag = ShortenerTag.builder()
                    .profile(profile)
                    .type(ShortLinkType.ORGANIZATION)
                    .shortLink(request.getLinkReduzido())
                    .redirectLink(request.getUrlRedirect())
                    .creationDate(new Date())
                    .uuid(request.getUuid())
                    .gs1DigitalLink(request.getGs1DigitalLink())
                    .gtin(request.getGtin())
                    .build();
            return shortenerRepository.saveAndFlush(shortenerTag);
        } catch (final Exception exception) {
            log.error("[ProductUseCaseImpl] save failed with: {}", exception.getMessage());
            notifyGateway.notify(new NotifyExceptionEventDTO(this, exception));
            throw exception;
        }
    }


}
