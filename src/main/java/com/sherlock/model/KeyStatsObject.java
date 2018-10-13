package com.sherlock.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class KeyStatsObject {
    
    private String companyName;
    private String marketcap;
    private String beta;
    private String week52high;
    private String week52low;
    private String week52change;
    private String shortInterest;
    private String shortDate;
    private String dividendRate;
    private String dividendYield;
    private String exDividendDate;
    private String latestEPS;
    private String latestEPSDate;
    private String sharesOutstanding;
    private String float_;
    private String returnOnEquity;
    private String consensusEPS;
    private String numberOfEstimates;
    private String EPSSurpriseDollar;
    private String EPSSurprisePercent;
    private String symbol;
    private String EBITDA;
    private String revenue;
    private String grossProfit;
    private String cash;
    private String debt;
    private String ttmEPS;
    private String revenuePerShare;
    private String revenuePerEmployee;
    private String peRatioHigh;
    private String peRatioLow;
    private String returnOnAssets;
    private String returnOnCapital;
    private String profitMargin;
    private String priceToSales;
    private String priceToBook;
    private String day200MovingAvg;
    private String day50MovingAvg;
    private String institutionPercent;
    private String insiderPercent;
    private String shortRatio;
    private String year5ChangePercent;
    private String year2ChangePercent;
    private String year1ChangePercent;
    private String ytdChangePercent;
    private String month6ChangePercent;
    private String month3ChangePercent;
    private String month1ChangePercent;
    private String day5ChangePercent;
    private String day30ChangePercent;
}
