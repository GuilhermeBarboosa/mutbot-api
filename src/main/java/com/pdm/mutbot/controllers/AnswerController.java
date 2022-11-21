package com.pdm.mutbot.controllers;

import com.pdm.mutbot.models.Answer;
import com.pdm.mutbot.models.User;
import com.pdm.mutbot.models.dtos.requests.AnswerRequestDTO;
import com.pdm.mutbot.models.dtos.requests.UserRequestDTO;
import com.pdm.mutbot.models.dtos.responses.AnswerResponseDTO;
import com.pdm.mutbot.models.dtos.responses.UserResponseDTO;
import com.pdm.mutbot.repositories.AnswerRepository;
import com.pdm.mutbot.services.AnswerService;
import com.pdm.mutbot.services.UserService;
import com.treinamento.domain.entity.Cliente;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/asnwer")
public class AnswerController {


    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private AnswerService answerService;
    
    @Autowired
    private AnswerRepository answerRepository;

    @PostMapping(value = "/register")
    public ResponseEntity<AnswerResponseDTO> save(@RequestBody AnswerRequestDTO answerRequestDTO) {
        Answer createdAnswer= answerService.saveDTO(answerRequestDTO);
        AnswerResponseDTO answerResponseDTO = modelMapper.map(createdAnswer, AnswerResponseDTO.class);
        return ResponseEntity.ok(answerResponseDTO);
    }
    
    @GetMapping(value = "/find")
    public ResponseEntity<List<Answer>> findAll() {
        List<Answer> listAnswer= answerService.findAll();
        return ResponseEntity.ok(listAnswer);
    }
    
    @GetMapping("/find/{asnwerId}")
	public Optional<Answer> buscar(@PathVariable Long asnwerId){
		return answerService.findById(asnwerId);
	}
    
    @PutMapping("/update/{asnwerId}")
	public ResponseEntity<Answer> modificar(@Valid
											 @PathVariable Long answerId,
											 @RequestBody Answer answer){
		if(!answerRepository.existsById(answerId)){
			return ResponseEntity.notFound().build();
		}else{
			answer.setId(answerId);
			answer = answerRepository.save(answer);
			return ResponseEntity.ok(answer);
		}
	}

	@DeleteMapping("/delete/{asnwerId}")
	public ResponseEntity<Answer> deletar(@PathVariable Long answerId){
		if(!answerRepository.existsById(answerId)){
			return ResponseEntity.notFound().build();
		}else{
			answerRepository.deleteById(answerId);
			return ResponseEntity.noContent().build();
		}
	}
    
}
