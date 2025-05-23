package com.gestaotamias.usuario.infrastructure.repository;

import com.gestaotamias.usuario.controller.dtos.EntradaDTO;
import com.gestaotamias.usuario.infrastructure.entity.Entrada;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {


    Optional<Entrada> findById(Long id);


}
