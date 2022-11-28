package com.pdm.mutbot.repositories.queries.question;

import com.pdm.mutbot.models.Question;
import com.pdm.mutbot.models.dtos.params.ListQuestionParams;

import java.util.List;

public interface QuestionQueries {

    List<Question> list(ListQuestionParams params);
}
