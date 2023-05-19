package br.com.cod2d.api.gateway.impl.repository.jpa;

import br.com.cod2d.api.domain.model.LinkGs1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LinkRepository extends JpaRepository<LinkGs1, Long> {

    @Query(value = "SELECT alpha_numeric4()", nativeQuery = true)
    String sequence();

}
