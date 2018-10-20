package com.sherlock.jdbc;

import com.sherlock.model.ResponseObject;

import javax.sql.DataSource;

public interface ResposneObjectDAO {

    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * This is the method to be used to create
     * a record in the Student table.
     */
    public void create(ResponseObject responseObject);


    /**
     * This is the method to be used to list down
     * all the records from the FINANCIAL_DATA table.
     */
    public Iterable<ResponseObject> query(String sql);

}
