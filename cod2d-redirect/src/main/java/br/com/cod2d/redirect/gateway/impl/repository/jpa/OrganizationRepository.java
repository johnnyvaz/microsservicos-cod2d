package br.com.cod2d.redirect.gateway.impl.repository.jpa;

import br.com.cod2d.redirect.domain.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Optional<Organization> findByShortName(String shortname);

    @Query(value = "select o from Organization o where o.uuid = UNHEX(REPLACE(:organization ,'-','')) ")
    Optional<Organization> findByOrganizationUuid(String organization);

}
