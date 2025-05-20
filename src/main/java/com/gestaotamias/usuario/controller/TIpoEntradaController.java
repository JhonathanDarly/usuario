package com.gestaotamias.usuario.controller;



import com.gestaotamias.usuario.infrastructure.entity.TipoEntrada;
import com.gestaotamias.usuario.infrastructure.security.JwtUtil;
import com.gestaotamias.usuario.service.TipoEntradaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/tipoEntrada")
@RequiredArgsConstructor
public class TIpoEntradaController {

    private final TipoEntradaService TipoEntradaService;

    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<TipoEntrada> salvarTipoEntrada(@RequestBody TipoEntrada TipoEntrada) {
        TipoEntrada salvo = TipoEntradaService.salvarTipoEntrada(TipoEntrada);
        return ResponseEntity.ok(salvo);
    }


    @GetMapping
    public ResponseEntity<TipoEntrada> buscarTipoEntradaPorNome(@RequestParam("nome") String nome) {
        return ResponseEntity.ok(TipoEntradaService.buscarTipoEntradaPorNome(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEntrada> buscarTipoEntradaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(TipoEntradaService.buscarTipoEntradaPorId(id));
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<Void> deletaTipoEntradaPorNome(@PathVariable String nome) {
        TipoEntradaService.deletarTipoEntradaPorNome(nome);
        return ResponseEntity.ok().build();
    }
}

