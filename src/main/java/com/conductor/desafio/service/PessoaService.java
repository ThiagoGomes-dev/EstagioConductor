package com.conductor.desafio.service;

import com.conductor.desafio.model.Pessoa;
import com.conductor.desafio.repository.PessoaRepository;
import com.conductor.desafio.request.PessoaRequest;
import com.conductor.desafio.response.PessoaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

/** Inserindo Pessoa na base de dados **/
    public void inserir(PessoaRequest pessoaRequest){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(null);
        pessoa.setDocumento(pessoaRequest.getDocumento());
        pessoa.setNome(pessoaRequest.getNome());
        pessoa.setSexo(pessoaRequest.getSexo());
        pessoa.setDataNascimento(pessoaRequest.getDataNascimento());

        pessoaRepository.save(pessoa);

    }
    /** Coletando ID da pessoa **/
    public Pessoa getId(Integer id){
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        return optionalPessoa.get();
    }
    /** Buscando pessoa na base de dados pelo ID **/
    public PessoaResponse buscarPorId(Integer id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.map(PessoaResponse::new).get();
    }
    /** Listando Pessoas por pagina **/
    public Page<PessoaResponse> listar(Pageable pageable) {
        return pessoaRepository.findAll(pageable).map(PessoaResponse::new);
    }

//    public List<PessoaResponse> listarPessoaFisica(PessoaRequest pessoaRequest) {
//        String verificar = pessoaRequest.getDocumento();
//      List<Pessoa> pessoas = pessoaRepository.findAll();
// List<Pessoa> pessoasFisica = new ArrayList<>();
//      List<Pessoa> pessoasJuridica = new ArrayList<>();
//
//        if (isPF) {
 //          return pessoasFisica;
 //       } if (!isPF) {
//            return pessoasJuridica;
//        } else {
//          return null; // Retorna lista de pessoas fisicas ou jurica
//        }
 //   }
}
