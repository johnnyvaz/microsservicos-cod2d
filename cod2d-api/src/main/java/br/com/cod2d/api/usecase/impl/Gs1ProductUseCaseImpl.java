package br.com.cod2d.api.usecase.impl;

import br.com.cod2d.api.domain.dto.gs1.ProductGs1QueueDTO;
import br.com.cod2d.api.domain.dto.gs1.RequestGs1ProductDTO;
import br.com.cod2d.api.domain.exception.LimiteExcedidoException;
import br.com.cod2d.api.domain.exception.OrganizationNotFoundException;
import br.com.cod2d.api.domain.model.Organization;
import br.com.cod2d.api.gateway.NotifyGateway;
import br.com.cod2d.api.gateway.impl.repository.jpa.OrganizationRepository;
import br.com.cod2d.api.usecase.Gs1ProductUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class Gs1ProductUseCaseImpl implements Gs1ProductUseCase {

    private final OrganizationRepository organizationRepository;
    private final NotifyGateway notifyGateway;

    private final SendGtinQueueUseCaseImpl sendGtinQueueUseCase;


    public Boolean send(final RequestGs1ProductDTO gtin, final String organizationUuid)
            throws JsonProcessingException {
        try {

            // busca e valida empresa
            log.info("busca empresa pelo uuid {}", organizationUuid);
            final Organization organization = organizationRepository.findByOrganizationUuid(
                    organizationUuid).orElseThrow(() -> new OrganizationNotFoundException(
                    "Código UUID inválido ou Empresa Não encontrada"));
            log.info("Empresa encontrada : {}", organization.getFantasia());

            // valida se usuário é da empresa

            // UUID destes registros
            final UUID currentUuid = UUID.randomUUID();
            log.info("current uuid : {}", currentUuid);

            // enviar mensagem para fila
            final ProductGs1QueueDTO gtinBuilder = ProductGs1QueueDTO.builder()
                    .creationDate(new Date())
                    .uuid(currentUuid)
                    .gtin(gtin.getGtin())
                    .uuidEmpresa(organization.getUuid())
                    .build();
            sendGtinQueueUseCase.sendProductUuid(gtinBuilder);

            return true;
        } catch (final LimiteExcedidoException exception) {
            final String msgLog = "Limite Excedido, total contratado: {} " + exception.getMessage();
            log.error(msgLog);
//            notifyGateway.notify(new NotifyExceptionEventDTO(this, exception));
            throw exception;
        } catch (final Exception exception) {
            log.error("[ProductUseCaseImpl] save failed with: {}", exception.getMessage());
//            notifyGateway.notify(new NotifyExceptionEventDTO(this, exception));
            throw exception;
        }
    }

}
