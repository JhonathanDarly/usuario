package com.gestaotamias.usuario.infrastructure.repository;



import com.gestaotamias.usuario.infrastructure.entity.TipoEntrada;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoEntradaRepository extends JpaRepository<TipoEntrada, Long> {

    boolean existsByNome(String nome);

    boolean existsById(Long id);

    Optional<TipoEntrada> findByNome(String nome);

    Optional<TipoEntrada> findById(Long id);

    @Transactional
    void deleteByNome(String nome);
}
