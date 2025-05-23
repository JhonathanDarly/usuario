package com.gestaotamias.usuario.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaidaDTO {

    private LocalDate data_lancamento;
    private Long tipoSaida_id;
    private double valor;

}
