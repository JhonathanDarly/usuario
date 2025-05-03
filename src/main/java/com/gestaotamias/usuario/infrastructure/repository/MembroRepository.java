package com.gestaotamias.usuario.infrastructure.repository;
import com.gestaotamias.usuario.infrastructure.entity.Membro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

    boolean existsByLogin(String login);

    Optional<Membro> findByLogin(String login);

    Optional<Membro> findByNome(String nome);

    @Transactional
    void deleteByLogin(String login);
}