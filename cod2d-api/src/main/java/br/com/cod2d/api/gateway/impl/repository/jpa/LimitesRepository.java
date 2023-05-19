package br.com.cod2d.api.gateway.impl.repository.jpa;

import br.com.cod2d.api.domain.model.QuantidadeLimites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LimitesRepository extends JpaRepository<QuantidadeLimites, Long> {

}
