package com.gestaotamias.usuario.service;

import com.gestaotamias.usuario.controller.dtos.EntradaDTO;
import com.gestaotamias.usuario.infrastructure.entity.Entrada;
import com.gestaotamias.usuario.infrastructure.entity.Membro;
import com.gestaotamias.usuario.infrastructure.entity.TipoEntrada;
import com.gestaotamias.usuario.infrastructure.exceptions.ResourceNotFoundException;
import com.gestaotamias.usuario.infrastructure.repository.EntradaRepository;
import com.gestaotamias.usuario.infrastructure.repository.MembroRepository;
import com.gestaotamias.usuario.infrastructure.repository.TipoEntradaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class EntradaService {

    private final EntradaRepository entradaRepository;
    private final MembroRepository membroRepository;
    private final TipoEntradaRepository tipoEntradaRepository;

    public EntradaDTO salvarEntrada(EntradaDTO entradaDto) {
        try {
            Entrada entrada = new Entrada();

            // Converter data
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date data = sdf.parse(entradaDto.getDataLancamento());
            entrada.setDataLancamento(data);

            // Buscar e associar Membro
            Membro membro = membroRepository.findById(entradaDto.getMembro_id())
                    .orElseThrow(() -> new RuntimeException("Membro não encontrado"));
            entrada.setMembro(membro);

            // Buscar e associar TipoEntrada
            TipoEntrada tipoEntrada = tipoEntradaRepository.findById(entradaDto.getTipoEntrada_id())
                    .orElseThrow(() -> new RuntimeException("Tipo de Entrada não encontrado"));
            entrada.setTipoEntrada(tipoEntrada);

            entrada.setValor(entradaDto.getValor());

            Entrada entradaSalva = entradaRepository.save(entrada);

            // Preencher DTO de retorno, se precisar
            EntradaDTO dtoResposta = new EntradaDTO();
            dtoResposta.setDataLancamento(entradaDto.getDataLancamento());
            dtoResposta.setValor(entradaSalva.getValor());
            dtoResposta.setMembro_id(membro.getId());
            dtoResposta.setTipoEntrada_id(tipoEntrada.getId());

            return dtoResposta;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar entrada: " + e.getMessage(), e);
        }
    }

    public Entrada buscarEntradaPorId(Long id) {
        return entradaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID não encontrado! " + id));
    }

    public void deletarEntrada(Long id) {
        entradaRepository.deleteById(id);
    }
}
