package com.pdm.mutbot.services;

import com.pdm.mutbot.models.Response;
import com.pdm.mutbot.models.Tag;
import com.pdm.mutbot.models.dtos.params.ListResponseParams;
import com.pdm.mutbot.models.dtos.params.ListTagParams;
import com.pdm.mutbot.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    public List<Tag> list(ListTagParams params) {
        return tagRepository.list(params);
    }
}
