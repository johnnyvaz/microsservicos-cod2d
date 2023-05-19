package br.com.cod2d.redirect.gateway.impl.repository.jpa;

import br.com.cod2d.redirect.domain.model.Shortener;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ShortenerRepository extends JpaRepository<Shortener, Long> {

    @Cacheable(value = "RedirectShortLink", unless = "#result == null")
    @Query(value = "select s from Shortener s where s.shortLink = :shortlink")
    Shortener findShortlink(String shortlink);

}
