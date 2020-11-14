package com.conductor.desafio.repository;

import com.conductor.desafio.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import java.time.LocalDate;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
