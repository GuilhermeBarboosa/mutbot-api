package com.pdm.mutbot.models.abstracts;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class DefaultEntityDTO {

    private LocalDateTime lastUpdatedDate;
    private LocalDateTime createdDate;
    private Boolean active;
}
