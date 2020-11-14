package com.conductor.desafio.controller;

import com.conductor.desafio.request.ContaResquest;
import com.conductor.desafio.service.ContaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody ContaResquest contaResquest){
        contaService.inserir(contaResquest);

        return ResponseEntity.ok().build();
    }
}
