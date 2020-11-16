package com.conductor.desafio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PESSOAS")

/** Criando Tabela Pessoa **/
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PESSOA")
    private Integer id;

    @Column(name ="DOCUMENTO", unique = true, length = 14)
    private String documento;

    @Column(name ="NOME", length = 100)
    private String nome;

    @Column(name ="SEXO", length = 1)
    private String Sexo;

    @Column(name ="DATA_NASCIMENTO")
    private LocalDate dataNascimento;

}

