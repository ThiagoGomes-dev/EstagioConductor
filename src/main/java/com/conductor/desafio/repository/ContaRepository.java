package com.conductor.desafio.repository;

import com.conductor.desafio.model.Conta;
import com.conductor.desafio.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

    Optional<Conta> findByPessoa(Pessoa pessoa);
}
