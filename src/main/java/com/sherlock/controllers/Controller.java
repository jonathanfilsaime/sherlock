package com.sherlock.controllers;

import com.sherlock.iex.IexApiCalls;
import com.sherlock.model.SymbolObjectResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    IexApiCalls iexApiCalls = new IexApiCalls();

    @RequestMapping(value = "/hello")
    public String hello()
    {
        return "hello";
    }

    @RequestMapping(value = "/financials")
    public void financials()
    {
        for (SymbolObjectResponse symbol : iexApiCalls.getTickers().getBody())
        {
            System.out.println(symbol.getName());
            System.out.println(iexApiCalls.getFinancials(symbol.getSymbol()).getBody());
            System.out.println("============");
        }
    }

    @RequestMapping(value = "/tickers")
    public void tickers()
    {
        for (SymbolObjectResponse symbol: iexApiCalls.getTickers().getBody())
        {
            System.out.println(symbol.getSymbol());
        }
    }

}
