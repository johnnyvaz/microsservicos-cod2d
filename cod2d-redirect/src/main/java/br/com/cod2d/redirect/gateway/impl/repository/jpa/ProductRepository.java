package br.com.cod2d.redirect.gateway.impl.repository.jpa;

import br.com.cod2d.redirect.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p from Product p  where p.organization = UNHEX(REPLACE(:organization ,'-','')) ")
    List<Product> findAllProductByOrganizationUuid(String organization);



}
