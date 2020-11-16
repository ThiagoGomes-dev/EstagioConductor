package com.conductor.desafio.service;

import com.conductor.desafio.model.Cartao;
import com.conductor.desafio.model.Conta;
import com.conductor.desafio.repository.CartaoRepository;
import com.conductor.desafio.request.CartaoResquest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartaoService {

    private final CartaoRepository cartaoRepository;
    private final ContaService contaService;

    /** Inserindo Cartao na base de dados **/
    public void inserir(CartaoResquest cartaoResquest){
        Conta contaAtual = contaService.getId(cartaoResquest.getContaId());
        Cartao cartao = new Cartao();
        cartao.setId(null);
        cartao.setNumero(cartaoResquest.getNumero());
        cartao.setPortador(cartaoResquest.getPortador());
        cartao.setConta(contaAtual);

        cartaoRepository.save(cartao);
    }


}
