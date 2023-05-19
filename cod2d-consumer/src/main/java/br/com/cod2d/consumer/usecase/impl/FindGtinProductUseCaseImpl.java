package br.com.cod2d.consumer.usecase.impl;

import br.com.cod2d.consumer.domain.dto.UuidProductQueueDTO;
import br.com.cod2d.consumer.domain.dto.gs1.response.ResponseProductGS1;
import br.com.cod2d.consumer.domain.exceptions.ProductNotFoundException;
import br.com.cod2d.consumer.domain.model.gtinbase.ProductGS1;
import br.com.cod2d.consumer.gateway.Gs1ClientGateway;
import br.com.cod2d.consumer.gateway.NotifyGateway;
import br.com.cod2d.consumer.gateway.impl.repository.jpa.ProductGs1Repository;
import br.com.cod2d.consumer.usecase.FindGtinProductUseCase;
import br.com.cod2d.consumer.usecase.mapper.ProductGs1Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindGtinProductUseCaseImpl implements FindGtinProductUseCase {

    private final NotifyGateway notifyGateway;
    private final Gs1ClientGateway gs1ClientGateway;
    private final ProductGs1Map productGs1Map;
    private final ProductGs1Repository productGs1Repository;


    public void run(final UuidProductQueueDTO uuidProduct) {
        try {
            log.info("Busca Produto no Banco");
//            final var getProduct = productRepository.findProductByUuid(uuidProduct.getUuid());
//            if (getProduct.isEmpty()) throw new ProductNotFoundException();

            final ResponseProductGS1 gtinFinded = gs1ClientGateway.getGtin(uuidProduct.getGtin());
            // se achar gravar no banco
            final ProductGS1 saveProductGs1 = productGs1Map.toProductGs1(gtinFinded);
            productGs1Repository.save(saveProductGs1);

            log.info("Resposta Maker API: {}", saveProductGs1);

        } catch (final Exception exception) {
            log.error("[ProductUseCaseImpl] save failed with: {}", exception.getMessage());
//            notifyGateway.notify(new NotifyExceptionEventDTO(this, exception));
            throw new ProductNotFoundException();
        }
    }

}
