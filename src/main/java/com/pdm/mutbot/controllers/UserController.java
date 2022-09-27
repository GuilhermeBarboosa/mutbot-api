package com.pdm.mutbot.controllers;

import com.pdm.mutbot.models.User;
import com.pdm.mutbot.models.dtos.requests.UserRequestDTO;
import com.pdm.mutbot.models.dtos.responses.UserResponseDTO;
import com.pdm.mutbot.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {


    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserResponseDTO> save(@RequestBody UserRequestDTO userRequestDTO) {
        User createdUser = userService.saveDTO(userRequestDTO);
        UserResponseDTO userResponseDTO = modelMapper.map(createdUser, UserResponseDTO.class);
        return ResponseEntity.ok(userResponseDTO);
    }
}
