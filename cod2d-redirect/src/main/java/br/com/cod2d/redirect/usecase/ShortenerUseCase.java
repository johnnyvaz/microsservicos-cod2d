package br.com.cod2d.redirect.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpHeaders;

public interface ShortenerUseCase {

    String getLink(final String shortLink, final HttpHeaders headers) throws JsonProcessingException;

}
