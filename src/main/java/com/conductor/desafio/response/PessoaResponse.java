package com.conductor.desafio.response;

import com.conductor.desafio.model.Pessoa;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaResponse {

    @ApiModelProperty(position = 1)
    private Integer id;

    @ApiModelProperty(position = 2)
    private String documento;

    @ApiModelProperty(position = 3)
    private String nome;

    @ApiModelProperty(position = 4)
    private String sexo;

    @ApiModelProperty(position = 5)
    private LocalDate dataNascimento;

    public PessoaResponse(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.documento = pessoa.getDocumento();
        this.sexo = pessoa.getSexo();
        this.dataNascimento = pessoa.getDataNascimento();
    }
}
