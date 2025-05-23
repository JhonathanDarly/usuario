package com.gestaotamias.usuario.controller;

import com.gestaotamias.usuario.infrastructure.entity.TipoEntrada;
import com.gestaotamias.usuario.infrastructure.entity.TipoSaida;
import com.gestaotamias.usuario.service.TipoSaidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/tipoSaida")
@RequiredArgsConstructor
public class TipoSaidaController {

    private final TipoSaidaService tipoSaidaService;

    @PostMapping
    public ResponseEntity<TipoSaida> salvarTipoSaida(@RequestBody TipoSaida tipoSaida){
        TipoSaida salvo = tipoSaidaService.salvarTipoSaida(tipoSaida);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<TipoSaida> buscarTipoSaidaPorNome(@RequestParam("nome") String nome){
        return ResponseEntity.ok(tipoSaidaService.buscarTipoSaidaPorNome(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoSaida> buscarTipoSaidaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tipoSaidaService.buscarTipoSaidaPorId(id));
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<Void> deletaTipoSaidaPorNome(@PathVariable String nome) {
        tipoSaidaService.deletarTipoSaidaPorNome(nome);
        return ResponseEntity.ok().build();
    }

}
