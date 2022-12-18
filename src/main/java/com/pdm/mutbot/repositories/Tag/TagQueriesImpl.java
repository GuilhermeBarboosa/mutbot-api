package com.pdm.mutbot.repositories.Tag;

import com.pdm.mutbot.models.Response;
import com.pdm.mutbot.models.Tag;
import com.pdm.mutbot.models.dtos.params.ListResponseParams;
import com.pdm.mutbot.models.dtos.params.ListTagParams;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TagQueriesImpl implements TagQueries{

    @Autowired
    EntityManager manager;

    @Override
    public List list(ListTagParams params) {
        String sql = "select tag " +
                "from Tag tag ";
        sql += getSqlParams(params);

        Query query = getParameters(sql, params);

        return query.getResultList();
    }

    private String getSqlParams(ListTagParams params) {
        String sqlParams = "";

        if (params.getOrderBy() != null && params.getOrderType() != null) {
            sqlParams += "order by " + params.getOrderBy() + " " + params.getOrderType();
        }
        return sqlParams;
    }

    private Query getParameters(String sql, ListTagParams params) {

        Query query = manager.createQuery(sql, Tag.class);

        if (params.getPageable().equals(true) && params.getPageSize() > 0 && params.getPageIndex() > -1) {
            query.setFirstResult(params.getPageIndex() * params.getPageSize());
            query.setMaxResults(params.getPageSize());
        }
        return query;
    }
}
