package com.gestaotamias.usuario.infrastructure.repository;

import com.gestaotamias.usuario.infrastructure.entity.Membros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembrosRepository extends JpaRepository<Membros, Long> {



}
