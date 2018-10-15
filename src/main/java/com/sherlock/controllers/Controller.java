package com.sherlock.controllers;

import com.sherlock.computation.ResponseCreator;
import com.sherlock.iex.IexApiCalls;
import com.sherlock.model.ResponseObject;
import com.sherlock.model.SymbolObjectResponse;
import com.sherlock.repository.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    MetricRepository repository;

    @RequestMapping(path ="/test")
    public Iterable<ResponseObject> test()
    {
        return repository.findAllStocks();
    }

    @RequestMapping(path="/findall")
    public Iterable<ResponseObject> findAll()
    {
        return repository.findAll();
    }

    @RequestMapping(path="/stock/{ticker}", produces = "application/json")
    public String stock(@PathVariable String ticker)
    {
        ResponseCreator responseCreator = new ResponseCreator();
        ResponseObject value = responseCreator.create(ticker);
        return (value != null) ? value.toString() : "nothing Here mate";
    }

    @RequestMapping(value="/load", produces = "application/json")
    public String all()
    {
        List<String> metrics = new ArrayList<>();
        IexApiCalls iexApiCalls = new IexApiCalls();

        int count = 0;

        for(SymbolObjectResponse ticker : iexApiCalls.getTickers().getBody())
        {
            count++;
            System.err.println("*******"+ ticker.getSymbol());

            ResponseCreator responseCreator = new ResponseCreator();
            ResponseObject value = responseCreator.create(ticker.getSymbol());

            if(value != null)
            {
                System.err.println(value.toString());
                metrics.add(value.toString());
                repository.save(value);

                if(count > 20)
                {
                    break;
                }
            }
            continue;


        }

        return metrics.toString();
    }
}





