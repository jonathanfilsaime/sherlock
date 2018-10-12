package com.sherlock.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class KeyStatsObject {
    
    private String companyName;
    private BigDecimal marketcap;
    private BigDecimal beta;
    private BigDecimal week52high;
    private BigDecimal week52low;
    private BigDecimal week52change;
    private BigDecimal shortInterest;
    private String shortDate;
    private BigDecimal dividendRate;
    private BigDecimal dividendYield;
    private String exDividendDate;
    private BigDecimal latestEPS;
    private String latestEPSDate;
    private BigDecimal sharesOutstanding;
    private BigDecimal float_;
    private BigDecimal returnOnEquity;
    private BigDecimal consensusEPS;
    private BigDecimal numberOfEstimates;
    private BigDecimal EPSSurpriseDollar;
    private BigDecimal EPSSurprisePercent;
    private String symbol;
    private BigDecimal EBITDA;
    private BigDecimal revenue;
    private BigDecimal grossProfit;
    private BigDecimal cash;
    private BigDecimal debt;
    private BigDecimal ttmEPS;
    private BigDecimal revenuePerShare;
    private BigDecimal revenuePerEmployee;
    private BigDecimal peRatioHigh;
    private BigDecimal peRatioLow;
    private BigDecimal returnOnAssets;
    private BigDecimal returnOnCapital;
    private BigDecimal profitMargin;
    private BigDecimal priceToSales;
    private BigDecimal priceToBook;
    private BigDecimal day200MovingAvg;
    private BigDecimal day50MovingAvg;
    private BigDecimal institutionPercent;
    private BigDecimal insiderPercent;
    private BigDecimal shortRatio;
    private BigDecimal year5ChangePercent;
    private BigDecimal year2ChangePercent;
    private BigDecimal year1ChangePercent;
    private BigDecimal ytdChangePercent;
    private BigDecimal month6ChangePercent;
    private BigDecimal month3ChangePercent;
    private BigDecimal month1ChangePercent;
    private BigDecimal day5ChangePercent;
    private BigDecimal day30ChangePercent;
}
