package br.com.cod2d.redirect.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpHeaders;

public interface RedirectUseCase {

    String postLink(final HttpHeaders headers) throws JsonProcessingException;

}
