package com.sherlock.iex;

import com.sherlock.validation.Validation;
import com.sherlock.model.FinancialDataObject;
import com.sherlock.model.Financials;
import com.sherlock.model.KeyStatsObject;
import com.sherlock.model.SymbolObjectResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//TODO move the buildEmptyFinancialDataObject() method to the exception handler
public class IexApiCalls {

    private final String URL_FINANCIAL_START = "https://api.iextrading.com/1.0/stock/";
    private final String URL_FINANCIAL_END = "/financials?period=annual";
    private final String URL_STATS_START = "https://api.iextrading.com/1.0/stock/";
    private final String URL_STATS_END = "/stats";
    private final String URL_SYMBOL = "https://api.iextrading.com/1.0/ref-data/symbols";

    public FinancialDataObject getFinancials(String ticker)
    {
        RestTemplate restTemplate = new RestTemplate();
        try
        {
            ResponseEntity<FinancialDataObject> financialDataObjectResponseEntity =
                    restTemplate.getForEntity(URL_FINANCIAL_START+ticker+URL_FINANCIAL_END, FinancialDataObject.class);

            if(Validation.validateFinancialDataObject(financialDataObjectResponseEntity))
            {
                return financialDataObjectResponseEntity.getBody();
            }
            else
            {
                return buildEmptyFinancialDataObject(ticker);
            }
        }
        catch (Exception e)
        {
            return buildEmptyFinancialDataObject(ticker);
        }
    }

    public KeyStatsObject getKeyStats(String ticker)
    {
        RestTemplate restTemplate = new RestTemplate();
        try
        {
            ResponseEntity<KeyStatsObject> responseEntity =
                    restTemplate.getForEntity(URL_STATS_START+ticker+URL_STATS_END, KeyStatsObject.class);
            if(Validation.validateKeyStatsObject(responseEntity))
            {
                return responseEntity.getBody();
            }
            else
            {
                return buildEmptyKeyStatsObject(ticker);
            }
        }
        catch (Exception e)
        {
            return buildEmptyKeyStatsObject(ticker);
        }
    }

    public ResponseEntity<SymbolObjectResponse[]> getTickers()
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(URL_SYMBOL, SymbolObjectResponse[].class);
    }

    private FinancialDataObject buildEmptyFinancialDataObject(String ticker)
    {
        Financials financials = new Financials();
        FinancialDataObject financialDataObject = new FinancialDataObject();

        financials.setReportDate("-1");
        financials.setGrossProfit("-1");
        financials.setCostOfRevenue("-1");
        financials.setOperatingRevenue("-1");
        financials.setTotalRevenue("-1");
        financials.setOperatingIncome("-1");
        financials.setNetIncome("-1");
        financials.setResearchAndDevelopment("-1");
        financials.setOperatingExpense("-1");
        financials.setCurrentAssets("-1");
        financials.setTotalAssets("-1");
        financials.setTotalLiabilities("-1");
        financials.setCurrentCash("-1");
        financials.setCurrentDebt("-1");
        financials.setTotalCash("-1");
        financials.setTotalDebt("-1");
        financials.setShareholderEquity("-1");
        financials.setCashChange("-1");
        financials.setCashFlow("-1");
        financials.setOperatingGainsLosses("-1");

        Financials[] financialArray = new Financials[1];
        financialArray[0] = financials;

        financialDataObject.setSymbol(ticker);
        financialDataObject.setFinancials(financialArray);

        return financialDataObject;
    }

    private KeyStatsObject buildEmptyKeyStatsObject(String ticker)
    {
        KeyStatsObject keyStatsObject = new KeyStatsObject();
        keyStatsObject.setCompanyName("-1");
        keyStatsObject.setMarketcap("-1");
        keyStatsObject.setBeta("-1");
        keyStatsObject.setWeek52high("-1");
        keyStatsObject.setWeek52low("-1");
        keyStatsObject.setWeek52change("-1");
        keyStatsObject.setShortInterest("-1");
        keyStatsObject.setShortDate("-1");
        keyStatsObject.setDividendRate("-1");
        keyStatsObject.setDividendYield("-1");
        keyStatsObject.setExDividendDate("-1");
        keyStatsObject.setLatestEPS("-1");
        keyStatsObject.setLatestEPSDate("-1");
        keyStatsObject.setSharesOutstanding("-1");
        keyStatsObject.setFloat_("-1");
        keyStatsObject.setReturnOnEquity("-1");
        keyStatsObject.setConsensusEPS("-1");
        keyStatsObject.setNumberOfEstimates("-1");
        keyStatsObject.setEPSSurpriseDollar("-1");
        keyStatsObject.setEPSSurprisePercent("-1");
        keyStatsObject.setSymbol(ticker);
        keyStatsObject.setEBITDA("-1");
        keyStatsObject.setRevenue("-1");
        keyStatsObject.setGrossProfit("-1");
        keyStatsObject.setCash("-1");
        keyStatsObject.setDebt("-1");
        keyStatsObject.setTtmEPS(ticker);
        keyStatsObject.setRevenuePerShare("-1");
        keyStatsObject.setRevenuePerEmployee("-1");
        keyStatsObject.setPeRatioHigh("-1");
        keyStatsObject.setPeRatioLow("-1");
        keyStatsObject.setReturnOnAssets("-1");
        keyStatsObject.setReturnOnCapital("-1");
        keyStatsObject.setProfitMargin("-1");
        keyStatsObject.setPriceToSales("-1");
        keyStatsObject.setPriceToBook("-1");
        keyStatsObject.setDay200MovingAvg("-1");
        keyStatsObject.setDay50MovingAvg("-1");
        keyStatsObject.setInstitutionPercent("-1");
        keyStatsObject.setInsiderPercent("-1");
        keyStatsObject.setShortRatio("-1");
        keyStatsObject.setYear5ChangePercent("-1");
        keyStatsObject.setYear2ChangePercent("-1");
        keyStatsObject.setYear1ChangePercent("-1");
        keyStatsObject.setYtdChangePercent("-1");
        keyStatsObject.setMonth6ChangePercent("-1");
        keyStatsObject.setMonth3ChangePercent("-1");
        keyStatsObject.setMonth1ChangePercent("-1");
        keyStatsObject.setDay5ChangePercent("-1");
        keyStatsObject.setDay30ChangePercent("-1");

        return keyStatsObject;
    }
}
