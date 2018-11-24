package com.sherlock.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ResponseObjectJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> query(String sql) {
        List<Map<String, Object>> responseObjects = jdbcTemplate.queryForList(sql);

        return responseObjects;
    }


}
