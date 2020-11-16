package com.conductor.desafio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CARTOES")

/** Criando Tabela Cartao **/
public class Cartao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARTAO")
    private Integer id;

    @Column(name = "NUMERO", length = 16)
    private String numero;

    @Column(name = "PORTADOR")
    private Integer portador;

    @ManyToOne
    @JoinColumn(name = "ID_CONTA")
    private Conta conta;

}
