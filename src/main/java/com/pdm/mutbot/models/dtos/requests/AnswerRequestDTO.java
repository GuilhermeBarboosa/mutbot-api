package com.pdm.mutbot.models.dtos.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.pdm.mutbot.models.Question;
import com.pdm.mutbot.models.User;

@Data
public class AnswerRequestDTO {

    private Long id;

    @NotEmpty(message = "Campo obrigatório.")
    @Size(max = 255, message = "Campo resposta só poder conter no máximo 255 caracteres.")
    private String text;

    private User author;
    
    private Question question;
}
