package com.pdm.mutbot.services;

import com.pdm.mutbot.models.User;
import com.pdm.mutbot.models.dtos.requests.UserRequestDTO;
import com.pdm.mutbot.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        BCryptPasswordEncoder pwEncode = new BCryptPasswordEncoder();
        user.setPassword(pwEncode.encode(userRequestDTO.getPassword()));
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
}
