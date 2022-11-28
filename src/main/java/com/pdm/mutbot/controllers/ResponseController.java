package com.pdm.mutbot.controllers;

import com.pdm.mutbot.models.Response;
import com.pdm.mutbot.models.dtos.params.ListResponseParams;
import com.pdm.mutbot.models.dtos.requests.ResponseResquestDTO;
import com.pdm.mutbot.models.dtos.responses.DefaultListResponseDTO;
import com.pdm.mutbot.models.dtos.responses.ResponseDTO;
import com.pdm.mutbot.services.ResponseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/responses")
public class ResponseController {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ResponseService responseService;

    @PostMapping()
    public ResponseEntity<ResponseDTO> save(@RequestBody ResponseResquestDTO resquestDTO) {
        Response responseSave = responseService.saveDTO(resquestDTO);
        ResponseDTO responseResponseDTO = modelMapper.map(responseSave, ResponseDTO.class);
        return ResponseEntity.ok(responseResponseDTO);
    }

    @GetMapping()
    public ResponseEntity<DefaultListResponseDTO<ResponseDTO>> list(ListResponseParams params){
        List<Response> countrys = responseService.list(params);
        List<ResponseDTO> countrysResponseDTO = countrys.stream().map(country -> modelMapper.map(country, ResponseDTO.class)).collect(Collectors.toList());
        DefaultListResponseDTO<ResponseDTO> response = new DefaultListResponseDTO<>(countrysResponseDTO);
        return ResponseEntity.ok(response);
    }
}
