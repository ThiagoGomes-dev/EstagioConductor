package com.conductor.desafio.service;

import com.conductor.desafio.model.Pessoa;
import com.conductor.desafio.repository.PessoaRepository;
import com.conductor.desafio.request.PessoaRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void inserir(PessoaRequest pessoaRequest){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(null);
        pessoa.setDocumento(pessoaRequest.getDocumento());
        pessoa.setNome(pessoaRequest.getNome());
        pessoa.setSexo(pessoaRequest.getSexo());
        pessoa.setDataNascimento(pessoaRequest.getDataNascimento());

        pessoaRepository.save(pessoa);

    }

    public Pessoa getId(Integer id){
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        return optionalPessoa.get();
    }
}
