package com.conductor.desafio.controller;

import com.conductor.desafio.request.ContaResquest;
import com.conductor.desafio.response.ContaResponse;
import com.conductor.desafio.response.PessoaResponse;
import com.conductor.desafio.service.ContaService;
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
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    /** Aqui estou inserindo uma conta na base de dados. **/
    @PostMapping
    @ApiOperation(value = "Cadastrar conta.", notes = "Este serviço insere uma conta na base de dados.", response = ContaResponse.class)
    public ResponseEntity<Void> inserir(@RequestBody ContaResquest contaResquest){
        contaService.inserir(contaResquest);

        return ResponseEntity.ok().build();
    }

    /** Aqui estou buscando uma conta através do ID. **/
    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar por ID.", notes = "Este serviço busca uma conta através do ID.", response = ContaResponse.class)
    public ResponseEntity<ContaResponse> findById(@NotNull @PathVariable Integer id,
                                                   @RequestParam Boolean isPF) {
        ContaResponse contaResponse = contaService.buscarPorPessoaId(id);
        return ResponseEntity.ok(contaResponse);
    }

    /** Aqui estou retornando todas as contas cadastradas na base de dados. **/
    @GetMapping
    @ApiOperation(value = "Listar contas.", notes = "Este serviço retorna todas as contas cadastradas na base de dados.", response = Page.class)
    public ResponseEntity<Page<ContaResponse>> findAll(
            @SortDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(contaService.listar(pageable));
    }
}
