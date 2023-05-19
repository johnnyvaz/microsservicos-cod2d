package br.com.cod2d.api.gateway.impl.repository.jpa;

import br.com.cod2d.api.domain.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query(value = "select p from Profile p where p.id = uuid(:profileid) ")
    Optional<Profile> findProfileBy(String profileid);

}
