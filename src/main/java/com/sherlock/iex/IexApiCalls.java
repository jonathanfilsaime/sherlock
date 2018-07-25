package com.sherlock.iex;

import com.sherlock.model.FinancialsResponseObject;
import com.sherlock.model.SymbolObjectResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class IexApiCalls {

    public ResponseEntity<FinancialsResponseObject> getFinancials(String ticker)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("https://api.iextrading.com/1.0/stock/"+ticker+"/financials", FinancialsResponseObject.class);
    }

    public ResponseEntity<SymbolObjectResponse[]> getTickers()
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("https://api.iextrading.com/1.0/ref-data/symbols", SymbolObjectResponse[].class);
    }

}
