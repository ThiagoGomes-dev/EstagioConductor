package com.conductor.desafio.controller;

import com.conductor.desafio.request.PessoaRequest;
import com.conductor.desafio.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody PessoaRequest pessoaRequest){
        pessoaService.inserir(pessoaRequest);

        return ResponseEntity.ok().build();
    }
}
