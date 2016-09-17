package com.bornstone.stonehenge.entity.query;

import com.bornstone.stonehenge.entity.IEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by king on 16-9-17.
 */
public class RPCPaginationQuery<T extends IEntity> implements Serializable {
    private PaginationQuery query;
    private List<T> result;

    public PaginationQuery getQuery() {
        return query;
    }

    public void setQuery(PaginationQuery query) {
        this.query = query;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
