package com.sherlock.controllers;

import com.sherlock.computation.ResponseCreator;
import com.sherlock.iex.IexApiCalls;
import com.sherlock.model.FinancialDataObject;
import com.sherlock.model.ResponseObject;
import com.sherlock.model.SymbolObjectResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @RequestMapping(path="/stock/{ticker}", produces = "application/json")
    public String stock(@PathVariable String ticker)
    {
        ResponseCreator responseCreator = new ResponseCreator();
        ResponseObject value = responseCreator.create(ticker);
        return (value != null) ? value.toString() : "nothing Here mate";
    }

    @RequestMapping(value="/all", produces = "application/json")
    public String all()
    {
        List<String> metrics = new ArrayList<>();
        IexApiCalls iexApiCalls = new IexApiCalls();
        for(SymbolObjectResponse ticker : iexApiCalls.getTickers().getBody())
        {
            System.err.println("*******"+ ticker.getSymbol());

            ResponseCreator responseCreator = new ResponseCreator();
            ResponseObject value = responseCreator.create(ticker.getSymbol());

            if(value != null)
            {
                System.err.println(value.toString());
                metrics.add(value.toString());
            }
            continue;
        }

        return metrics.toString();
    }
}





