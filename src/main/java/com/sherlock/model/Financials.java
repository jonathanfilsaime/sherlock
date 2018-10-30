package com.sherlock.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@Data
@ApiIgnore
@NoArgsConstructor
public class Financials {

    private String reportDate;
    private String grossProfit;
    private String costOfRevenue;
    private String operatingRevenue;
    private String totalRevenue;
    private String operatingIncome;
    private String netIncome;
    private String researchAndDevelopment;
    private String operatingExpense;
    private String currentAssets;
    private String totalAssets;
    private String totalLiabilities;
    private String currentCash;
    private String currentDebt;
    private String totalCash;
    private String totalDebt;
    private String shareholderEquity;
    private String cashChange;
    private String cashFlow;
    private String operatingGainsLosses;


}
