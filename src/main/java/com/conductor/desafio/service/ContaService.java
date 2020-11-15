package com.conductor.desafio.service;

import com.conductor.desafio.model.Conta;
import com.conductor.desafio.model.Pessoa;
import com.conductor.desafio.repository.ContaRepository;
import com.conductor.desafio.request.ContaResquest;
import com.conductor.desafio.response.ContaResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;
    private final PessoaService pessoaService;

    public void inserir(ContaResquest contaResquest) {
        Pessoa pessoaAtual = pessoaService.getId(contaResquest.getPessoaId());
        Conta conta = new Conta();
        conta.setId(null);
        conta.setPessoa(pessoaAtual);
        contaRepository.save(conta);
    }

    public Conta getId(Integer id){
        Optional<Conta> optionalConta = contaRepository.findById(id);
        return optionalConta.get();
    }

    public ContaResponse buscarPorPessoaId(Integer pessoaId) {
        Pessoa pessoa = pessoaService.getId(pessoaId);
        return contaRepository.findByPessoa(pessoa).map(ContaResponse::new).get();
    }

}