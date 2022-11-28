package com.pdm.mutbot.repositories;

import com.pdm.mutbot.models.Question;
import com.pdm.mutbot.repositories.queries.question.QuestionQueries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long>, QuestionQueries {
}
