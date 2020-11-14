package com.conductor.desafio.repository;

import com.conductor.desafio.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import java.time.LocalDate;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {


}
