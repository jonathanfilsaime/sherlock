package com.sherlock.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class ResponseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
    private BigDecimal operatingGainsLosses;
    private BigDecimal marketcap;
    private BigDecimal dividendRate;
    private BigDecimal dividendYield;
    private BigDecimal cashTrailingTwelveMonths;
    private BigDecimal debtTrailingTwelveMonths;
    private BigDecimal revenuePerShareTrailingTwelveMonths;
    private BigDecimal revenuePerEmployeeTrailingTwelveMonths;
    private BigDecimal returnOnAssetsTrailingTwelveMonths;
    private BigDecimal returnOnCapitalTrailingTwelveMonths;
    private BigDecimal profitMargin;
    private BigDecimal priceToSales;
    private BigDecimal priceToBook;
    private BigDecimal currentRatio;
    private BigDecimal cashRatio;
    private BigDecimal operatingCashFlowRatio;
    private BigDecimal debtRatio;
    private BigDecimal debtToEquityRatio;
    private BigDecimal debtServiceCoverageRatio;
    private BigDecimal assetTurnoverRatio;
    private BigDecimal grossMarginRatio;
    private BigDecimal operatingMarginRatio;
    private BigDecimal returnOnAssetsRatio;
    private BigDecimal returnOnEquityRatio;
}
