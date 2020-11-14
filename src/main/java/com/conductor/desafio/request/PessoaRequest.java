package com.conductor.desafio.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRequest {

    @ApiModelProperty(value = "Documento da Pessoa", example = "99999999999", position = 1)
    private String documento;

    @ApiModelProperty(value = "Nome da Pessoa", example = "Thiago", position = 2)
    private String nome;

    @ApiModelProperty(value = "Sexo da Pessoa", example = "M", position = 3)
    private String Sexo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "Data inicial da campanha.", example = "12/11/2020", position = 4)
    private LocalDate dataNascimento;
}
