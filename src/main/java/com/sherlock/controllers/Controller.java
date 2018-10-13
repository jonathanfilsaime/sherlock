package com.sherlock.controllers;

import com.sherlock.iex.IexApiCalls;
import com.sherlock.model.FinancialDataObject;
import com.sherlock.model.KeyStatsObject;
import com.sherlock.model.Ratios;
import com.sherlock.model.SymbolObjectResponse;
import org.springframework.http.ResponseEntity;
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
        ResponseEntity<FinancialDataObject> value = iexApiCalls.getFinancials(ticker);
        System.err.println(value.getBody());
        if(value.getBody().getFinancials() != null)
        {
            return iexApiCalls.getFinancials(ticker).getBody().getFinancials()[0].toString();
        }
        return "nothing there mate";
    }

    @RequestMapping(path="/keystats/{ticker}")
    public String keyStats(@PathVariable String ticker)
    {
        return iexApiCalls.getKeyStats(ticker).getBody().toString();
    }

    @RequestMapping(path="/ratios/{ticker}")
    public String ratios(@PathVariable String ticker)
    {
        ratios.setRatios(iexApiCalls.getFinancials(ticker).getBody().getFinancials()[0], iexApiCalls.getKeyStats(ticker).getBody());
        return ratios.getRatios().toString();
    }

    @RequestMapping(path="/object/{ticker}")
    public String object(@PathVariable String ticker)
    {
        return ratios(ticker) + financials(ticker);
    }

    @RequestMapping(value="/all")
    public String all()
    {
        List<String> metrics = new ArrayList<>();

        for(SymbolObjectResponse ticker : iexApiCalls.getTickers().getBody())
        {
            System.err.println("*******"+ ticker.getSymbol());
            ResponseEntity<FinancialDataObject> value = iexApiCalls.getFinancials(ticker.getSymbol());
            ResponseEntity<KeyStatsObject> keyStatsObject = iexApiCalls.getKeyStats(ticker.getSymbol());
            if(value.getBody().getFinancials() != null && keyStatsObject != null)
            {
                ratios.setRatios(value.getBody().getFinancials()[0], keyStatsObject.getBody());
                metrics.add(value.getBody().getFinancials()[0].toString() + ratios.getRatios().toString());
            }
            continue;
        }

        return metrics.toString();
    }
}





