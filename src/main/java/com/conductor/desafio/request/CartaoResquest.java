package com.conductor.desafio.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaoResquest {

    @ApiModelProperty(value = "Numero do Cartão", example = "0000000000000000", position = 1)
    private String numero;

    @ApiModelProperty(value = "Nome do Portador", example = "1", position = 2)
    private Integer portador;

    @ApiModelProperty(value = "Id conta", example = "00", position = 3)
    private Integer contaId;
}
