package com.pdm.mutbot.services;

import com.pdm.mutbot.models.User;
import com.pdm.mutbot.models.dtos.requests.UserRequestDTO;
import com.pdm.mutbot.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public User saveDTO(UserRequestDTO userRequestDTO) {
        User user = modelMapper.map(userRequestDTO, User.class);
        return userRepository.save(user);
    }
}
