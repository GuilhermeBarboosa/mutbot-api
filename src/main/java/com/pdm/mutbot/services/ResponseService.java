package com.pdm.mutbot.services;

import com.pdm.mutbot.models.Response;
import com.pdm.mutbot.models.dtos.params.ListResponseParams;
import com.pdm.mutbot.models.dtos.requests.ResponseResquestDTO;
import com.pdm.mutbot.repositories.ResponseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository responseRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public Response saveDTO(ResponseResquestDTO resquestDTO) {
        Response response = modelMapper.map(resquestDTO, Response.class);
        return responseRepository.save(response);
    }

    public List<Response> list(ListResponseParams params) {
        return responseRepository.list(params);
    }
}
