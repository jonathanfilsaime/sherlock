package com.sherlock.controllers;

import com.sherlock.iex.IexApiCalls;
import com.sherlock.model.Ratios;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    IexApiCalls iexApiCalls = new IexApiCalls();
    Ratios ratios = new Ratios();

    @RequestMapping(value = "/financials")
    public String financials()
    {
        return iexApiCalls.getFinancials().getBody().getFinancials()[0].toString();
    }

    @RequestMapping(value="/keystats")
    public String keyStats()
    {
        return iexApiCalls.getKeyStats().getBody().toString();
    }

    @RequestMapping(value="/ratios")
    public String ratios()
    {
        ratios.setRatios(iexApiCalls.getFinancials().getBody().getFinancials()[0], iexApiCalls.getKeyStats().getBody());
        return ratios.getRatios().toString();
    }

    @RequestMapping(value="/all")
    public String all()
    {
        ratios.setRatios(iexApiCalls.getFinancials().getBody().getFinancials()[0], iexApiCalls.getKeyStats().getBody());
        return iexApiCalls.getFinancials().getBody().getFinancials()[0].toString() + ratios.getRatios().toString();
    }
}





