package com.pdm.mutbot.models.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ResponseResquestDTO {

    private Long id;

    @NotEmpty(message = "Campo questão e obrigatório.")
    @Size(min = 2, message = "Campo questão e obrigatório no minimo 5 caracteres.")
    @Size(max = 2500, message = "Campo questão só poder conter no máximo 2500 caracteres.")
    private String response;

    private Long authorId;

    private Long questionId;
}
