package com.pdm.mutbot.repositories.queries.response;

import com.pdm.mutbot.models.Response;
import com.pdm.mutbot.models.dtos.params.ListResponseParams;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ResponseQueriesImpl implements ResponseQueries{

    @Autowired
    EntityManager manager;

    @Override
    public List list(ListResponseParams params) {
        String sql = "select response " +
                "from Response response " +
                "where ";
        sql += getSqlParams(params);

        Query query = getParameters(sql, params);

        return query.getResultList();
    }

    private String getSqlParams(ListResponseParams params) {
        String sqlParams = "";

        sqlParams += " response.active = true and ";
        sqlParams += " question.id = :questionId ";

        if (params.getOrderBy() != null && params.getOrderType() != null) {
            sqlParams += "order by " + params.getOrderBy() + " " + params.getOrderType();
        }

        return sqlParams;
    }

    private Query getParameters(String sql, ListResponseParams params) {

        Query query = manager.createQuery(sql, Response.class);

        query.setParameter("questionId", params.getQuestionId());

        if (params.getPageable().equals(true) && params.getPageSize() > 0 && params.getPageIndex() > -1) {
            query.setFirstResult(params.getPageIndex() * params.getPageSize());
            query.setMaxResults(params.getPageSize());
        }
        return query;
    }
}
