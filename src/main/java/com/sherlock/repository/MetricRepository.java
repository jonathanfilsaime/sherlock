package com.sherlock.repository;

import com.sherlock.model.ResponseObject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MetricRepository extends CrudRepository<ResponseObject, Long> {



    Iterable<ResponseObject> findAll();

    @Modifying
    @Query(value = "SELECT * FROM FINANCIAL_DATA WHERE GROSS_PROFIT > :amount LIMIT 50;", nativeQuery = true)
    Iterable<ResponseObject> findAllStocks(@Param("amount") String amount);

}


