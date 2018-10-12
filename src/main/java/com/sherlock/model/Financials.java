package com.sherlock.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Financials {

    private String reportDate;
    private Double grossProfit;
    private Double costOfRevenue;
    private Double operatingRevenue;
    private Double totalRevenue;
    private Double operatingIncome;
    private Double netIncome;
    private Double researchAndDevelopment;
    private Double operatingExpense;
    private Double currentAssets;
    private Double totalAssets;
    private Double totalLiabilities;
    private Double currentCash;
    private Double currentDebt;
    private Double totalCash;
    private Double totalDebt;
    private Double shareholderEquity;
    private Double cashChange;
    private Double cashFlow;
    private String operatingGainsLosses;


}
