package com.gestaotamias.usuario.service;

import com.gestaotamias.usuario.infrastructure.entity.TipoEntrada;
import com.gestaotamias.usuario.infrastructure.entity.TipoSaida;
import com.gestaotamias.usuario.infrastructure.exceptions.ResourceNotFoundException;
import com.gestaotamias.usuario.infrastructure.repository.TipoSaidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoSaidaService {

    private final TipoSaidaRepository tipoSaidaRepository;


    public TipoSaida salvarTipoSaida(TipoSaida tipoSaida){
        if(tipoSaidaRepository.existsByNome(tipoSaida.getNome())){
            throw new IllegalArgumentException("Já existe um TipoSaida com este nome!");
        }
        return tipoSaidaRepository.save(tipoSaida);
    }

    public TipoSaida buscarTipoSaidaPorNome(String nome){
        return tipoSaidaRepository.findByNome(nome).orElseThrow(() -> new ResourceNotFoundException("Nome não encontrado! " + nome));
    }

    public void deletarTipoSaidaPorNome(String nome){
        tipoSaidaRepository.deleteByNome(nome);
    }

    public TipoSaida buscarTipoSaidaPorId(Long id){
        return tipoSaidaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID não encontrado! " + id));
    }

}
