package com.pdm.mutbot.services;

import com.pdm.mutbot.models.Answer;
import com.pdm.mutbot.models.dtos.requests.AnswerRequestDTO;
import com.pdm.mutbot.models.dtos.responses.AnswerResponseDTO;
import com.pdm.mutbot.repositories.AnswerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository AnswerRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public Answer saveDTO(AnswerRequestDTO AnswerRequestDTO) {
        Answer answer = modelMapper.map(AnswerRequestDTO, Answer.class);
        return AnswerRepository.save(answer);
    }

    @Transactional
	public List<Answer> findAll() {
		return AnswerRepository.findAll();
	}

	public Optional<Answer> findById(Long asnwerId) {
		return AnswerRepository.findById(asnwerId);
	}
}
