package com.gestaotamias.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "saida")
public class Saida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_lancamento", length = 20)
    private LocalDate dataLancamento;

    @ManyToOne
    @JoinColumn(name = "tipoSaida_id")
    private TipoSaida tipoSaida;

    @Column(name = "valor")
    private Double valor;
}
