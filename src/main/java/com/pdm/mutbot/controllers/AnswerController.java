package com.pdm.mutbot.controllers;

import com.pdm.mutbot.models.Answer;
import com.pdm.mutbot.models.User;
import com.pdm.mutbot.models.dtos.requests.AnswerRequestDTO;
import com.pdm.mutbot.models.dtos.requests.UserRequestDTO;
import com.pdm.mutbot.models.dtos.responses.AnswerResponseDTO;
import com.pdm.mutbot.models.dtos.responses.UserResponseDTO;
import com.pdm.mutbot.services.AnswerService;
import com.pdm.mutbot.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/asnwer")
public class AnswerController {


    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private AnswerService answerService;

    @PostMapping(value = "/register")
    public ResponseEntity<AnswerResponseDTO> save(@RequestBody AnswerRequestDTO answerRequestDTO) {
        Answer createdAnswer= answerService.saveDTO(answerRequestDTO);
        AnswerResponseDTO answerResponseDTO = modelMapper.map(createdAnswer, AnswerResponseDTO.class);
        return ResponseEntity.ok(answerResponseDTO);
    }
    
//    @GetMapping(value = "/find")
//    public ResponseEntity<List<Answer>> findAll(@RequestBody AnswerRequestDTO answerRequestDTO) {
//        List<Answer> listAnswer= answerService.findAll(answerRequestDTO);
//        AnswerResponseDTO answerResponseDTO = modelMapper.map(listAnswer, AnswerResponseDTO.class);
//        return ResponseEntity.ok(listAnswer);
//    }
}
