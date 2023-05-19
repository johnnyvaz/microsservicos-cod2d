package br.com.cod2d.api.gateway.impl.repository.jpa;

import br.com.cod2d.api.domain.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Optional<Organization> findByCnpj(String cnpj);

    @Query(value = "select o from Organization o where o.uuid = uuid(:organization) ")
    Optional<Organization> findByOrganizationUuid(String organization);

}
