package com.sherlock.jdbc;

import com.sherlock.model.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ResponseObjectJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Iterable<ResponseObject> query(String sql) {
        Iterable<ResponseObject> responseObjects = jdbcTemplate.query(sql, new ResponseObjectRowMapper());
        return responseObjects;
    }


}
