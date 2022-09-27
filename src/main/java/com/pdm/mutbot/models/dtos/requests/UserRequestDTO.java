package com.pdm.mutbot.models.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserRequestDTO {

    private Long id;

    @NotEmpty(message = "Campo nome e obrigatório.")
    @Size(min = 2, message = "Campo nome e obrigatório no minimo 2 caracteres.")
    @Size(max = 255, message = "Campo nome só poder conter no máximo 255 caracteres.")
    private String name;

    @NotEmpty(message = "Campo email e obrigatório.")
    @Size(min = 2, message = "Campo email e obrigatório no minimo 2 caracteres.")
    @Size(max = 255, message = "Campo email só poder conter no máximo 255 caracteres.")
    private String email;

    @NotEmpty(message = "Campo login e obrigatório.")
    @Size(min = 2, message = "Campo login e obrigatório no minimo 2 caracteres.")
    @Size(max = 255, message = "Campo login só poder conter no máximo 255 caracteres.")
    private String userName;

    private String password;
}
