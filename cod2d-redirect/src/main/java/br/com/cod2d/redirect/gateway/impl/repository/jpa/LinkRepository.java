package br.com.cod2d.redirect.gateway.impl.repository.jpa;

import br.com.cod2d.redirect.domain.model.LinkGs1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LinkRepository extends JpaRepository<LinkGs1, Long> {

    @Query(value = "select l.urlRedirect from LinkGs1 l where l.stringRedirectFrom = :shortlink")
    String findShortlink(String shortlink);

}
