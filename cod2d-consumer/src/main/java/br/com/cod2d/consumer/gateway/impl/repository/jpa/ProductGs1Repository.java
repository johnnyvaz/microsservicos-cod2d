package br.com.cod2d.consumer.gateway.impl.repository.jpa;

import br.com.cod2d.consumer.domain.model.gtinbase.ProductGS1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductGs1Repository extends JpaRepository<ProductGS1, Long> {

}
