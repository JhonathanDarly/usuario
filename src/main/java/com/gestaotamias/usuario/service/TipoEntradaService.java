package com.gestaotamias.usuario.service;


import com.gestaotamias.usuario.infrastructure.entity.TipoEntrada;
import com.gestaotamias.usuario.infrastructure.exceptions.ResourceNotFoundException;
import com.gestaotamias.usuario.infrastructure.repository.TipoEntradaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoEntradaService {

    private final TipoEntradaRepository TipoEntradaRepository;
    private final PasswordEncoder passwordEncoder;

    public TipoEntrada salvarTipoEntrada(TipoEntrada TipoEntrada){
        if (TipoEntradaRepository.existsByNome(TipoEntrada.getNome())){
            throw new IllegalArgumentException("Já existe um TipoEntrada com este nome.");
        }

        return TipoEntradaRepository.save(TipoEntrada);
    }

    public TipoEntrada buscarTipoEntradaPorNome(String nome){
        return TipoEntradaRepository.findByNome(nome).orElseThrow(() -> new ResourceNotFoundException("Nome não encontrado! " + nome));
    }

    public void deletarTipoEntradaPorNome(String nome){
        TipoEntradaRepository.deleteByNome(nome);
    }

    public TipoEntrada buscarTipoEntradaPorId(Long id) {
        return TipoEntradaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID não encontrado! " + id));
    }
}
