package com.conductor.desafio.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaResquest {

    @ApiModelProperty(value = "Id pessoa", example = "01", position = 1)
    private Integer pessoaId;
}
