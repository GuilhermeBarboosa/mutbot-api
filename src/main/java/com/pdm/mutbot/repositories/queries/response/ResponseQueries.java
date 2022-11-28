package com.pdm.mutbot.repositories.queries.response;

import com.pdm.mutbot.models.Response;
import com.pdm.mutbot.models.dtos.params.ListResponseParams;

import java.util.List;

public interface ResponseQueries {

    List<Response> list(ListResponseParams params);
}
