package com.pdm.mutbot.models.dtos.responses;

import lombok.Data;

import com.pdm.mutbot.models.Question;
import com.pdm.mutbot.models.User;

@Data
public class AnswerResponseDTO {

    private Long id;
    
    private String text;

    private User author;
    
    private Question question;
}
