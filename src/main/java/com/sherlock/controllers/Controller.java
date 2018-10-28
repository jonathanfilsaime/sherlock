package com.sherlock.controllers;

import com.sherlock.computation.QueryParser;
import com.sherlock.computation.ResponseCreator;
import com.sherlock.iex.IexApiCalls;
import com.sherlock.jdbc.ResponseObjectJdbcRepository;
import com.sherlock.model.RequestObject;
import com.sherlock.model.ResponseObject;
import com.sherlock.model.SymbolObjectResponse;
import com.sherlock.repository.ResponseObjectCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class Controller {

    Logger logger = LoggerFactory.getLogger(Controller.class.getName());

    @Autowired
    ResponseObjectCrudRepository responseObjectCrudRepository;

    @Autowired
    ResponseObjectJdbcRepository responseObjectJdbcRepository;

    @RequestMapping(path="/search/param")
    public Iterable<ResponseObject> searchParam(@RequestParam(value="search", required=true) String sql)
    {
        QueryParser qp = new QueryParser();
        logger.info(qp.parse(sql));
        return responseObjectJdbcRepository.query(qp.parse(sql));
    }

    @RequestMapping(path="/search", method = RequestMethod.POST, consumes="application/json")
    public void search(@RequestBody RequestObject requestObject)
    {
        QueryParser qp = new QueryParser();
        System.err.println("requestObject" + qp.parseRequest(requestObject));
    }

    @RequestMapping(value="/load", produces = "application/json")
    public Iterator<ResponseObject> all()
    {
        IexApiCalls iexApiCalls = new IexApiCalls();
        SymbolObjectResponse[] tickerSymbols = iexApiCalls.getTickers().getBody();

        int count = 0;

        for(SymbolObjectResponse tickerSymbol : tickerSymbols)
        {
            logger.info("ticker symbol: "+ tickerSymbol.getSymbol());

            ResponseCreator responseCreator = new ResponseCreator();
            ResponseObject value = responseCreator.create(tickerSymbol.getSymbol());

            if(value != null && value.getREPORT_DATE() != "-1")
            {
                logger.info("values: " + value.toString());
                responseObjectCrudRepository.save(value);
            }
            count++;

            if(count > 30)
            {
                break;
            }

        }

        logger.info("number fo rows: " + String.valueOf(responseObjectCrudRepository.count()));

        return responseObjectCrudRepository.findAll().iterator();
    }
}





