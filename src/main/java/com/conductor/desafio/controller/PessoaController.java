package com.conductor.desafio.controller;

import com.conductor.desafio.request.PessoaRequest;
import com.conductor.desafio.response.PessoaResponse;
import com.conductor.desafio.service.PessoaService;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    /** Aqui estou inserindo uma pessoa na base de dados. **/
    @PostMapping
    @ApiOperation(value = "Cadastrar pessoa.", notes = "Este serviço insere uma pessoa na base de dados.", response = PessoaResponse.class)
    public ResponseEntity<Void> inserir(@NotNull @RequestBody PessoaRequest pessoaRequest){
        pessoaService.inserir(pessoaRequest);

        return ResponseEntity.ok().build();
    }
    /** Aqui estou buscando uma pessoa através do ID. **/
    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar por ID.", notes = "Este serviço busca uma pessoa através do ID.", response = PessoaResponse.class)
    public ResponseEntity<PessoaResponse> findById(@NotNull @PathVariable Integer id,
                                                   @RequestParam Boolean isPF) {
        PessoaResponse pessoaResponse = pessoaService.buscarPorId(id);
        return ResponseEntity.ok(pessoaResponse);
    }
    /**Aqui estou retornando todas as pessoas cadastradas na base de dados **/
    @GetMapping
    @ApiOperation(value = "Listar pessoas", notes = "Este serviço retorna todas as pessoas cadastradas na base de dados.", response = Page.class)
    public ResponseEntity<Page<PessoaResponse>> findAll(
            @SortDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(pessoaService.listar(pageable));
    }
}
