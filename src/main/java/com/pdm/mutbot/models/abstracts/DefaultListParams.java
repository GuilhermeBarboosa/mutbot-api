package com.pdm.mutbot.models.abstracts;

import lombok.Data;

@Data
public abstract class DefaultListParams {

    private Boolean pageable = Boolean.TRUE;

    private Integer pageIndex = 0;

    private Integer pageSize = 10;

    private String orderBy;

    private String orderType;
}