package com.pdm.mutbot.models.dtos.responses;

import com.pdm.mutbot.models.abstracts.DefaultEntityDTO;
import lombok.Data;

@Data
public class QuestionResponseDTO extends DefaultEntityDTO {

    private Long id;

    private String question;

    private Long authorId;

    private String authorName;
}
