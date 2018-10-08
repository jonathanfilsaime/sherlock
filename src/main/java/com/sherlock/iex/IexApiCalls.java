package com.sherlock.iex;

import com.sherlock.model.FinancialDataObject;
import com.sherlock.model.KeyStatsObject;
import com.sherlock.model.SymbolObjectResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class IexApiCalls {

    private final String URL_FINANCIAL = "https://api.iextrading.com/1.0/stock/";
    private final String URL_SYMBOL = "https://api.iextrading.com/1.0/ref-data/symbols";

    public ResponseEntity<FinancialDataObject> getFinancials()
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("https://api.iextrading.com/1.0/stock/tsla/financials?period=annual", FinancialDataObject.class);
    }

    public ResponseEntity<KeyStatsObject> getKeyStats()
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("https://api.iextrading.com/1.0/stock/tsla/stats", KeyStatsObject.class);
    }

    public ResponseEntity<SymbolObjectResponse[]> getTickers()
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(URL_SYMBOL, SymbolObjectResponse[].class);
    }

}
