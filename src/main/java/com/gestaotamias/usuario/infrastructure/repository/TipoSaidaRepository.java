package com.gestaotamias.usuario.infrastructure.repository;

import com.gestaotamias.usuario.infrastructure.entity.TipoSaida;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoSaidaRepository extends JpaRepository <TipoSaida, Long> {

    boolean existsByNome(String nome);

    Optional<TipoSaida> findByNome(String nome);

    Optional<TipoSaida> findById(Long id);

    @Transactional
    void deleteByNome(String nome);
}
