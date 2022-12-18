package com.pdm.mutbot.controllers;

import com.pdm.mutbot.models.Question;
import com.pdm.mutbot.models.Tag;
import com.pdm.mutbot.models.dtos.params.ListQuestionParams;
import com.pdm.mutbot.models.dtos.params.ListTagParams;
import com.pdm.mutbot.models.dtos.requests.QuestionResquestDTO;
import com.pdm.mutbot.models.dtos.responses.DefaultListResponseDTO;
import com.pdm.mutbot.models.dtos.responses.QuestionResponseDTO;
import com.pdm.mutbot.models.dtos.responses.TagResponseDTO;
import com.pdm.mutbot.services.QuestionService;
import com.pdm.mutbot.services.TagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tags")
public class TagController {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private TagService tagService;


    @GetMapping()
    public ResponseEntity<DefaultListResponseDTO<TagResponseDTO>> list(ListTagParams params){
        List<Tag> tags = tagService.list(params);
        List<TagResponseDTO> tagsResponseDTO = tags.stream().map(tag -> modelMapper.map(tag, TagResponseDTO.class)).collect(Collectors.toList());
        DefaultListResponseDTO<TagResponseDTO> response = new DefaultListResponseDTO<>(tagsResponseDTO);
        return ResponseEntity.ok(response);
    }
}
