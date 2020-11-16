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
@Table(name = "CONTAS")

/** Criando Tabela Conta **/
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTA")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA" )
    private Pessoa pessoa;

}
