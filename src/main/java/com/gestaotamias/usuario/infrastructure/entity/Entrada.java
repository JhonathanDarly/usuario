package com.gestaotamias.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.lang.model.element.Name;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "entrada")
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dataLancamento", length = 20)
    private String dataLancamento;

    @ManyToOne
    @JoinColumn(name = "membro_id")
    private Membro membro;

    @Column(name = "valor")
    private double valor;

    @ManyToOne
    @JoinColumn(name = "tipoEntrada_id")
    private  TipoEntrada tipoEntrada;


}
