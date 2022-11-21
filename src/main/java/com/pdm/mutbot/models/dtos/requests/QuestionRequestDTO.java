package com.pdm.mutbot.models.dtos.requests;

import lombok.Data;

import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.pdm.mutbot.models.TagQuestion;
import com.pdm.mutbot.models.User;

@Data
public class QuestionRequestDTO {

    private Long id;

    @NotEmpty(message = "Campo nome e obrigatório.")
    @Size(max = 255, message = "Campo nome só poder conter no máximo 255 caracteres.")
    private String title;

    @NotEmpty(message = "Campo pergunta e obrigatório.")
    @Size(max = 255, message = "Campo pergunta só poder conter no máximo 255 caracteres.")
    private String text;

    private User author;
    
    private Set<TagQuestion> tags;
}
