package com.conductor.desafio.service;

import com.conductor.desafio.model.Conta;
import com.conductor.desafio.model.Pessoa;
import com.conductor.desafio.repository.ContaRepository;
import com.conductor.desafio.request.ContaResquest;
import com.conductor.desafio.response.ContaResponse;
import com.conductor.desafio.response.PessoaResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
@AllArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;
    private final PessoaService pessoaService;
    private Object List;

    /** Inserindo Conta na base de dados. **/
    public void inserir(ContaResquest contaResquest) {
        Pessoa pessoaAtual = pessoaService.getId(contaResquest.getPessoaId());
        Conta conta = new Conta();
        conta.setId(null);
        conta.setPessoa(pessoaAtual);
        contaRepository.save(conta);
    }
    /** Coletando Id da Conta **/
    public Conta getId(Integer id){
        Optional<Conta> optionalConta = contaRepository.findById(id);
        return optionalConta.get();
    }
    /** Buscando Conta pelo ID. **/
    public ContaResponse buscarPorPessoaId(Integer pessoaId) {
        Pessoa pessoa = pessoaService.getId(pessoaId);
        return contaRepository.findByPessoa(pessoa).map(ContaResponse::new).get();
    }
    /** Listando Contas por paginas. **/
    public Page<ContaResponse> listar(Pageable pageable) {
        return contaRepository.findAll(pageable).map(ContaResponse::new);
    }
//    public ContaResponse listarContaPessoa findAll(){
//        List list = contaRepository.findAll();
//        return list;
//    }

}