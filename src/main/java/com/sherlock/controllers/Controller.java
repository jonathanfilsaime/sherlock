package com.sherlock.controllers;

import com.sherlock.iex.IexApiCalls;
import com.sherlock.model.Financials;
import com.sherlock.model.FinancialsResponseObject;
import com.sherlock.model.SymbolObjectResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    IexApiCalls iexApiCalls = new IexApiCalls();

    @RequestMapping(value = "/financials")
    public void financials()
    {
        for (SymbolObjectResponse symbol : iexApiCalls.getTickers().getBody())
        {
            FinancialsResponseObject object = iexApiCalls.getFinancials(symbol.getSymbol()).getBody();
            if(object.getSymbol() != null)
            {
                System.out.println(symbol.getSymbol());
                System.out.println(symbol.getName());

                for(int i = 0; i < object.getFinancials().length; i++)
                {
                    System.out.println("*****" +
                            "");
                    System.out.println("date : "+object.getFinancials()[i].getReportDate());
                    System.out.println("cash change : "+object.getFinancials()[i].getCashChange());
                    System.out.println("Cash flow : "+object.getFinancials()[i].getCashFlow());
                    System.out.println("cost of revenue : "+object.getFinancials()[i].getCostOfRevenue());
                    System.out.println("current assets : "+object.getFinancials()[i].getCurrentAssets());
                    System.out.println("current cash : "+object.getFinancials()[i].getCurrentCash());
                    System.out.println("current debt : "+object.getFinancials()[i].getCurrentDebt());
                    System.out.println("net income : "+object.getFinancials()[i].getNetIncome());
                    System.out.println("operating expense : "+object.getFinancials()[i].getOperatingExpense());
                    System.out.println("gains or losses : "+object.getFinancials()[i].getOperatingGainsLosses());
                    System.out.println("operating income : "+object.getFinancials()[i].getOperatingIncome());
                    System.out.println("operating revenue : "+object.getFinancials()[i].getOperatingRevenue());
                    System.out.println("research and development : "+object.getFinancials()[i].getResearchAndDevelopment());
                    System.out.println("total assets : "+object.getFinancials()[i].getTotalAssets());
                    System.out.println("total cash : "+object.getFinancials()[i].getTotalCash());
                    System.out.println("total debt : "+object.getFinancials()[i].getTotalDebt());
                    System.out.println("total liabilities : "+object.getFinancials()[i].getTotalLiabilities());
                    System.out.println("total revenue : "+object.getFinancials()[i].getTotalRevenue());  
                }
                

            }
            System.out.println("============================================");
        }
    }



}
