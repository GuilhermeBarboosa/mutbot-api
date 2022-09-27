package com.pdm.mutbot.models.dtos.responses;

import com.pdm.mutbot.models.abstracts.DefaultEntityDTO;
import lombok.Data;

@Data
public class UserResponseDTO extends DefaultEntityDTO {

    private Long id;

    private String name;

    private String email;

    private String sap;

    private String username;
}
