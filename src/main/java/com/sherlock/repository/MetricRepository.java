package com.sherlock.repository;

import com.sherlock.model.ResponseObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MetricRepository extends CrudRepository<ResponseObject, Long> {

    String value="SELECT * FROM FINANCIAL_DATA WHERE NET_INCOME > 10000000000";

    Iterable<ResponseObject> findAll();

    @Query(
            value=value,
            nativeQuery = true)
    Iterable<ResponseObject> findAllStocks();
}
