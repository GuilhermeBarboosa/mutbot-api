package com.pdm.mutbot.repositories;

import com.pdm.mutbot.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
