package com.sherlock.controllers;

import com.sherlock.computation.QueryParser;
import com.sherlock.computation.ResponseCreator;
import com.sherlock.iex.IexApiCalls;
import com.sherlock.jdbc.ResponseObjectJdbcRepository;
import com.sherlock.model.RequestObject;
import com.sherlock.model.ResponseObject;
import com.sherlock.model.SymbolObjectResponse;
import com.sherlock.repository.ResponseObjectCrudRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    Logger logger = LoggerFactory.getLogger(Controller.class.getName());

    @Autowired
    ResponseObjectCrudRepository responseObjectCrudRepository;

    @Autowired
    ResponseObjectJdbcRepository responseObjectJdbcRepository;

    /**
     * this resource allows the SHERLOCK database to be queried provided
     * that the string value of the search param is correctly formatted
     * @param sql
     * @return a JSON ResponseObject
     */
    @ApiOperation(value = "Returns rows which meets the conditions passed in", response = ResponseObject.class)
    @RequestMapping(path="/search/param", method = RequestMethod.GET, produces = "application/json")
    public List<Map<String, Object>> searchParam(@RequestParam(value="search", required=true) String sql)
    {
        QueryParser qp = new QueryParser();
        logger.info("sql string: " + sql);
        logger.info("sql parse string: " + qp.parse(sql));
        return responseObjectJdbcRepository.query(qp.parse(sql));
    }

    /**
     * this resource allows the SHERLOCK database to be queried provided the
     * JSON object in the body is correctly formatted
     * @param requestObject
     */
    @ApiOperation(value = "Returns rows which meets the conditions passed in", response = ResponseObject.class)
    @RequestMapping(path="/search", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public List<Map<String, Object>> search(@Valid @RequestBody RequestObject requestObject)
    {
        QueryParser qp = new QueryParser();
        logger.info("request object:" + requestObject);
        logger.info("request Object parse: " + qp.parseRequest(requestObject));
        return responseObjectJdbcRepository.query(qp.parseRequest(requestObject));
    }

    /**
     * this resource is only to be used to populate the SHERLOCK database
     * it is not public and should not be publicly exposed on Open Cortex
     * @return a JSON ResponseObject
     */
    @ApiIgnore
//    @RequestMapping(value="/load", produces = "application/json")
    public Iterator<ResponseObject> all()
    {
        IexApiCalls iexApiCalls = new IexApiCalls();
        SymbolObjectResponse[] tickerSymbols = iexApiCalls.getTickers().getBody();

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
        }

        logger.info("number fo rows: " + String.valueOf(responseObjectCrudRepository.count()));
        return responseObjectCrudRepository.findAll().iterator();
    }
}





