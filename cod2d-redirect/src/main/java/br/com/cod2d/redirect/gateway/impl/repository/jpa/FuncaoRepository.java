package br.com.cod2d.redirect.gateway.impl.repository.jpa;

import br.com.cod2d.redirect.domain.model.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncaoRepository extends JpaRepository<Funcao, Long> {

    Optional<Funcao> findByName(String name);
}
