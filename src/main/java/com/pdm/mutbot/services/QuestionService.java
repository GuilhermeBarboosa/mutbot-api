package com.pdm.mutbot.services;

import com.pdm.mutbot.models.Question;
import com.pdm.mutbot.models.User;
import com.pdm.mutbot.models.dtos.params.ListQuestionParams;
import com.pdm.mutbot.models.dtos.requests.QuestionResquestDTO;
import com.pdm.mutbot.models.dtos.requests.UserRequestDTO;
import com.pdm.mutbot.repositories.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public Question saveDTO(QuestionResquestDTO resquestDTO) {
        Question question = modelMapper.map(resquestDTO, Question.class);
        return questionRepository.save(question);
    }

    public List<Question> list(ListQuestionParams params) {
        return questionRepository.list(params);
    }
}
