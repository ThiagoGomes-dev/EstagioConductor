package com.conductor.desafio.controller;

import com.conductor.desafio.request.CartaoResquest;
import com.conductor.desafio.service.CartaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/cartoes")
public class CartaoController {

    private final CartaoService cartaoService;

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody CartaoResquest cartaoResquest){
        cartaoService.inserir(cartaoResquest);

        return ResponseEntity.ok().build();
    }

}
