package com.pdm.mutbot.models.dtos.params;

import com.pdm.mutbot.models.abstracts.DefaultListParams;
import lombok.Data;

@Data
public class ListResponseParams extends DefaultListParams {

    private Long questionId;
}
