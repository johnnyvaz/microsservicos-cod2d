package br.com.cod2d.redirect.gateway.impl.repository.jpa;

import br.com.cod2d.redirect.domain.model.SerialShipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SerialShippingRepository extends JpaRepository<SerialShipping, Long> {

    @Query(value = "select s from SerialShipping s  where s.uuid = UNHEX(REPLACE(:uuid ,'-','')) ")
    SerialShipping findByUuid(String uuid);



}
