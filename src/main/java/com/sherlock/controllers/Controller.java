package com.sherlock.controllers;

import com.sherlock.computation.QueryParser;
import com.sherlock.computation.ResponseCreator;
import com.sherlock.iex.IexApiCalls;
import com.sherlock.jdbc.ResponseObjectJdbcRepository;
import com.sherlock.model.ResponseObject;
import com.sherlock.model.SymbolObjectResponse;
import com.sherlock.repository.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    MetricRepository repository;

    @Autowired
    ResponseObjectJdbcRepository responseObjectJdbcRepository;

    @RequestMapping(path="/search")
    public Iterable<ResponseObject> repo1(@RequestParam(value="search", required=true) String sql)
    {
        QueryParser qp = new QueryParser();
        System.err.println(qp.parse(sql));
        return responseObjectJdbcRepository.query(qp.parse(sql));
    }

    @RequestMapping(value="/load", produces = "application/json")
    public String all()
    {
        List<String> metrics = new ArrayList<>();
        IexApiCalls iexApiCalls = new IexApiCalls();

        for(SymbolObjectResponse ticker : iexApiCalls.getTickers().getBody())
        {
            System.err.println("*******"+ ticker.getSymbol());

            ResponseCreator responseCreator = new ResponseCreator();
            ResponseObject value = responseCreator.create(ticker.getSymbol());

            if(value != null && value.getREPORT_DATE() != "-1")
            {
                System.err.println(value.toString());
                metrics.add(value.toString());
                repository.save(value);
            }
            continue;
        }

        return metrics.toString();
    }
}





