package br.com.cod2d.redirect.gateway;

import br.com.cod2d.redirect.domain.model.Shortener;

public interface RepositoryGateway {

    Shortener findShortlink(final String shortlink);
}
