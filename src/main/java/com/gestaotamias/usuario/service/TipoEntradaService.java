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

    private final TipoEntradaRepository tipoEntradaRepository;
    private final PasswordEncoder passwordEncoder;

    public TipoEntrada salvarTipoEntrada(TipoEntrada tipoEntrada){
        if (tipoEntradaRepository.existsByNome(tipoEntrada.getNome())){
            throw new IllegalArgumentException("Já existe um TipoEntrada com este nome.");
        }

        return tipoEntradaRepository.save(tipoEntrada);
    }

    public TipoEntrada buscarTipoEntradaPorNome(String nome){
        return tipoEntradaRepository.findByNome(nome).orElseThrow(() -> new ResourceNotFoundException("Nome não encontrado! " + nome));
    }

    public void deletarTipoEntradaPorNome(String nome){
        tipoEntradaRepository.deleteByNome(nome);
    }

    public TipoEntrada buscarTipoEntradaPorId(Long id) {
        return tipoEntradaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID não encontrado! " + id));
    }
}
