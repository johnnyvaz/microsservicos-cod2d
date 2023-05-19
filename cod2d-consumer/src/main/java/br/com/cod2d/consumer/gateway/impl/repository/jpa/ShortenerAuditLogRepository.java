package br.com.cod2d.consumer.gateway.impl.repository.jpa;

import br.com.cod2d.consumer.domain.model.ShortenerAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ShortenerAuditLogRepository extends JpaRepository<ShortenerAuditLog, Long> {

}
