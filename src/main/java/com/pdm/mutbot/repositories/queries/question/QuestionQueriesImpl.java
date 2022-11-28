package com.pdm.mutbot.repositories.queries.question;

import com.pdm.mutbot.models.Question;
import com.pdm.mutbot.models.dtos.params.ListQuestionParams;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class QuestionQueriesImpl implements QuestionQueries{

    @Autowired
    EntityManager manager;

    @Override
    public List list(ListQuestionParams params) {
        String sql = "select question " +
                "from Question question " +
                "where ";
        sql += getSqlParams(params);

        Query query = getParameters(sql, params);

        return query.getResultList();
    }

    private String getSqlParams(ListQuestionParams params) {
        String sqlParams = "";

        sqlParams += " question.active = true ";

        if (params.getOrderBy() != null && params.getOrderType() != null) {
            sqlParams += "order by " + params.getOrderBy() + " " + params.getOrderType();
        }

        return sqlParams;
    }

    private Query getParameters(String sql, ListQuestionParams params) {

        Query query = manager.createQuery(sql, Question.class);

        if (params.getPageable().equals(true) && params.getPageSize() > 0 && params.getPageIndex() > -1) {
            query.setFirstResult(params.getPageIndex() * params.getPageSize());
            query.setMaxResults(params.getPageSize());
        }
        return query;
    }
}
