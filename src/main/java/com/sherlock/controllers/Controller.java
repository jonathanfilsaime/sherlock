package com.sherlock.controllers;

import com.sherlock.iex.IexApiCalls;
import com.sherlock.model.Ratios;
import com.sherlock.model.SymbolObjectResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    IexApiCalls iexApiCalls = new IexApiCalls();
    Ratios ratios = new Ratios();

    @RequestMapping(path="/financials/{ticker}")
    public String financials(@PathVariable String ticker)
    {
        return iexApiCalls.getFinancials(ticker).getBody().getFinancials()[0].toString();
    }

    @RequestMapping(path="/keystats/{ticker}")
    @GetMapping("/{ticker}")
    public String keyStats(@PathVariable String ticker)
    {
        return iexApiCalls.getKeyStats(ticker).getBody().toString();
    }

    @RequestMapping(path="/ratios/{ticker}")
    @GetMapping("/{ticker}")
    public String ratios(@PathVariable String ticker)
    {
        ratios.setRatios(iexApiCalls.getFinancials(ticker).getBody().getFinancials()[0], iexApiCalls.getKeyStats(ticker).getBody());
        return ratios.getRatios().toString();
    }

    @RequestMapping(value="/all")
    public String all()
    {
        List<String> metrics = new ArrayList<>();

        for(SymbolObjectResponse ticker : iexApiCalls.getTickers().getBody())
        {
            System.err.println("*******"+ ticker.getSymbol());
            ratios.setRatios(iexApiCalls.getFinancials(ticker.getSymbol()).getBody().getFinancials()[0], iexApiCalls.getKeyStats(ticker.getSymbol()).getBody());
            metrics.add(iexApiCalls.getFinancials(ticker.getSymbol()).getBody().getFinancials()[0].toString() + ratios.getRatios().toString());
        }

        return metrics.toString();
    }
}





