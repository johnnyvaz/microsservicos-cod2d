package br.com.cod2d.redirect.gateway.impl.repository.jpa;

import br.com.cod2d.redirect.domain.model.ShortenerAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortenerAuditLogRepository extends JpaRepository<ShortenerAuditLog, Long> {

}
