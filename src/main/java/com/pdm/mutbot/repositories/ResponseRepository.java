package com.pdm.mutbot.repositories;

import com.pdm.mutbot.models.Response;
import com.pdm.mutbot.repositories.queries.response.ResponseQueries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response, Long>, ResponseQueries {
}
