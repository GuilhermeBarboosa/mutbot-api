package com.pdm.mutbot.models.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DefaultListResponseDTO<T> {
    private List<T> data;
}
