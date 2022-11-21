package com.pdm.mutbot.models.dtos.responses;

import lombok.Data;

import java.util.Set;

import com.pdm.mutbot.models.TagQuestion;
import com.pdm.mutbot.models.User;

@Data
public class QuestionResponseDTO {

    private Long id;

    private String title;

    private String text;

    private User author;
    
    private Set<TagQuestion> tags;
}
