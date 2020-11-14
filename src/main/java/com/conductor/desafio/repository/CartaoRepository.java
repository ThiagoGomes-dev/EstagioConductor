package com.conductor.desafio.repository;

import com.conductor.desafio.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import java.time.LocalDate;

public interface CartaoRepository  extends JpaRepository<Cartao, Integer> {

}
