package br.com.cod2d.api.gateway.impl.repository.jpa;

import br.com.cod2d.api.domain.model.ShortenerTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortenerRepository extends JpaRepository<ShortenerTag, Long> {

}
