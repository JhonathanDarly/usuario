package com.gestaotamias.usuario.controller.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaDTO {

    private String dataLancamento;
    private Long membro_id;
    private Long tipoEntrada_id;
    private double valor;
}
