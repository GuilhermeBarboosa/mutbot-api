package com.pdm.mutbot.controllers;

import com.pdm.mutbot.models.Question;
import com.pdm.mutbot.models.User;
import com.pdm.mutbot.models.dtos.params.ListQuestionParams;
import com.pdm.mutbot.models.dtos.requests.QuestionResquestDTO;
import com.pdm.mutbot.models.dtos.requests.UserRequestDTO;
import com.pdm.mutbot.models.dtos.responses.DefaultListResponseDTO;
import com.pdm.mutbot.models.dtos.responses.QuestionResponseDTO;
import com.pdm.mutbot.models.dtos.responses.UserResponseDTO;
import com.pdm.mutbot.services.QuestionService;
import com.pdm.mutbot.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private QuestionService questionService;

    @PostMapping()
    public ResponseEntity<QuestionResponseDTO> save(@RequestBody QuestionResquestDTO resquestDTO) {
        Question questionSave = questionService.saveDTO(resquestDTO);
        QuestionResponseDTO questionResponseDTO = modelMapper.map(questionSave, QuestionResponseDTO.class);
        return ResponseEntity.ok(questionResponseDTO);
    }

    @GetMapping()
    public ResponseEntity<DefaultListResponseDTO<QuestionResponseDTO>> list(ListQuestionParams params){
        List<Question> countrys = questionService.list(params);
        List<QuestionResponseDTO> countrysResponseDTO = countrys.stream().map(country -> modelMapper.map(country, QuestionResponseDTO.class)).collect(Collectors.toList());
        DefaultListResponseDTO<QuestionResponseDTO> response = new DefaultListResponseDTO<>(countrysResponseDTO);
        return ResponseEntity.ok(response);
    }
}
