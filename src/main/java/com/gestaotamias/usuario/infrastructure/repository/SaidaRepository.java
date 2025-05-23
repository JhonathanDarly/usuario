package com.gestaotamias.usuario.infrastructure.repository;

import com.gestaotamias.usuario.infrastructure.entity.Saida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaidaRepository extends JpaRepository<Saida, Long> {

    Optional<Saida> findById(Long id);

}
