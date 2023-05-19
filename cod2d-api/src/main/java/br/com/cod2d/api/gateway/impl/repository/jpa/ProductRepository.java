package br.com.cod2d.api.gateway.impl.repository.jpa;

import br.com.cod2d.api.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p from Product p  where p.organization = uuid(:organization) ")
    List<Product> findAllProductByOrganizationUuid(String organization);

    @Query(value = "select count(p) from Product p where p.organization = uuid(:organization) ")
    Long countProductsByOrganization(final String organization);

    @Query(value = "select p from Product p where p.uuid = uuid(:productUuid) ")
    Optional<Product> findProductByUuid(final String productUuid);

}
