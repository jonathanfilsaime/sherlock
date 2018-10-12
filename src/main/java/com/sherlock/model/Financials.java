package com.sherlock.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Financials {

    private String reportDate;
    private BigDecimal grossProfit;
    private BigDecimal costOfRevenue;
    private BigDecimal operatingRevenue;
    private BigDecimal totalRevenue;
    private BigDecimal operatingIncome;
    private BigDecimal netIncome;
    private BigDecimal researchAndDevelopment;
    private BigDecimal operatingExpense;
    private BigDecimal currentAssets;
    private BigDecimal totalAssets;
    private BigDecimal totalLiabilities;
    private BigDecimal currentCash;
    private BigDecimal currentDebt;
    private BigDecimal totalCash;
    private BigDecimal totalDebt;
    private BigDecimal shareholderEquity;
    private BigDecimal cashChange;
    private BigDecimal cashFlow;
    private String operatingGainsLosses;


}
