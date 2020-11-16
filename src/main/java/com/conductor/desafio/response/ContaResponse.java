package com.conductor.desafio.response;

import com.conductor.desafio.model.Conta;
import com.conductor.desafio.model.Pessoa;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaResponse {

    @ApiModelProperty(position = 1)
    private Integer id;

    @ApiModelProperty(position = 2)
    private PessoaResponse pessoa;

    /** Aqui estou pegando os dados para poder utilizar na Classe ContaService, que é onde faço a parte de inserir/listar **/
    public ContaResponse(Conta conta) {
        this.id = conta.getId();
        this.pessoa = new PessoaResponse(conta.getPessoa());
    }
}
