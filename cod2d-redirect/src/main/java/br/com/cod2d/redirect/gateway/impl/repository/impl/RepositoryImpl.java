package br.com.cod2d.redirect.gateway.impl.repository.impl;

import br.com.cod2d.redirect.domain.exception.ShortenerNotFoundException;
import br.com.cod2d.redirect.domain.model.Shortener;
import br.com.cod2d.redirect.gateway.RepositoryGateway;
import br.com.cod2d.redirect.gateway.impl.repository.jpa.ShortenerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RepositoryImpl implements RepositoryGateway {

    private final ShortenerRepository shortenerRepository;

    @Override
    public Shortener findShortlink(final String shortlink) {
        log.info("[RepositoryImpl] - buscando link no banco de dados : {}", shortlink);
        try {
            final String linkFull = "https://cd2.io/" + shortlink;
            return shortenerRepository.findShortlink(linkFull);
        } catch (final Exception ex) {
            log.error("Erro ao consultar banco de dados: {} ", ex.getMessage());
            throw new ShortenerNotFoundException(shortlink);
        }
    }

}
