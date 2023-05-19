package br.com.cod2d.redirect.gateway.impl.repository.jpa;

import br.com.cod2d.redirect.domain.model.QuantidadeLimites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LimitesRepository extends JpaRepository<QuantidadeLimites, Long> {

}
