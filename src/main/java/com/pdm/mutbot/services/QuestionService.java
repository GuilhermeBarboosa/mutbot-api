package com.pdm.mutbot.services;

import com.pdm.mutbot.models.Question;
import com.pdm.mutbot.models.dtos.requests.QuestionRequestDTO;
import com.pdm.mutbot.repositories.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public Question saveDTO(QuestionRequestDTO questionRequestDTO) {
    	Question question = modelMapper.map(questionRequestDTO, Question.class);
        return questionRepository.save(question);
    }
}
