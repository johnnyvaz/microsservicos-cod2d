package br.com.cod2d.consumer.gateway.impl.repository.jpa;

import br.com.cod2d.consumer.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p from Product p where p.uuid = uuid(:productUuid) ")
    Optional<Product> findProductByUuid(final UUID productUuid);


}
