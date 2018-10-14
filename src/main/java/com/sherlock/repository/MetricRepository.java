package com.sherlock.repository;

import com.sherlock.model.ResponseObject;
import org.springframework.data.repository.CrudRepository;

public interface MetricRepository extends CrudRepository<ResponseObject, Long> {

    Iterable<ResponseObject> findAll();
}
