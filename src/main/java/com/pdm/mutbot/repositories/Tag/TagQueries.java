package com.pdm.mutbot.repositories.Tag;

import com.pdm.mutbot.models.Response;
import com.pdm.mutbot.models.Tag;
import com.pdm.mutbot.models.dtos.params.ListResponseParams;
import com.pdm.mutbot.models.dtos.params.ListTagParams;

import java.util.List;

public interface TagQueries {

    List<Tag> list(ListTagParams params);
}
