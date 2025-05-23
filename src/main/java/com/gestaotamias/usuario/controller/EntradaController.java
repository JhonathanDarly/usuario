package com.gestaotamias.usuario.controller;


import com.gestaotamias.usuario.controller.dtos.EntradaDTO;
import com.gestaotamias.usuario.infrastructure.entity.Entrada;
import com.gestaotamias.usuario.infrastructure.entity.TipoEntrada;
import com.gestaotamias.usuario.service.EntradaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/entrada")
@RequiredArgsConstructor
public class EntradaController {

    private final EntradaService entradaService;



    @PostMapping
    public ResponseEntity<EntradaDTO> salvarEntrada(@RequestBody EntradaDTO entradaDTO){
        EntradaDTO salvo = entradaService.salvarEntrada(entradaDTO);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrada> buscarTipoEntradaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(entradaService.buscarEntradaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEntrada(@PathVariable Long id) {
        entradaService.deletarEntrada(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
