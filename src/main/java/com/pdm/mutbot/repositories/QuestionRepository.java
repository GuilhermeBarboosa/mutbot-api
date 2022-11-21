package com.pdm.mutbot.repositories;

import com.pdm.mutbot.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
