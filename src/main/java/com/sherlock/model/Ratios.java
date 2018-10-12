package com.sherlock.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ratios {

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
    private Map<String, BigDecimal> ratios;


    private BigDecimal getMarketCap()
    {
        return marketcap;
    }

    private void setMarketcap(KeyStatsObject keyStatsObject)
    {
        marketcap = keyStatsObject.getMarketcap();
    }

    public BigDecimal getDividendRate() {
        return dividendRate;
    }

    public void setDividendRate(KeyStatsObject keyStatsObject) {
        this.dividendRate = keyStatsObject.getDividendRate();
    }

    public BigDecimal getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(KeyStatsObject keyStatsObject) {
        this.dividendYield = keyStatsObject.getDividendYield();
    }

    public BigDecimal getCashTrailingTwelveMonths() {
        return cashTrailingTwelveMonths;
    }

    public void setCashTrailingTwelveMonths(KeyStatsObject keyStatsObject) {
        this.cashTrailingTwelveMonths = keyStatsObject.getCash();
    }

    public BigDecimal getDebtTrailingTwelveMonths() {
        return debtTrailingTwelveMonths;
    }

    public void setDebtTrailingTwelveMonths(KeyStatsObject keyStatsObject) {
        this.debtTrailingTwelveMonths = keyStatsObject.getDebt();
    }

    public BigDecimal getRevenuePerShareTrailingTwelveMonths() {
        return revenuePerShareTrailingTwelveMonths;
    }

    public void setRevenuePerShareTrailingTwelveMonths(KeyStatsObject keyStatsObject) {
        this.revenuePerShareTrailingTwelveMonths = keyStatsObject.getRevenuePerShare();
    }

    public BigDecimal getRevenuePerEmployeeTrailingTwelveMonths() {
        return revenuePerEmployeeTrailingTwelveMonths;
    }

    public void setRevenuePerEmployeeTrailingTwelveMonths(KeyStatsObject keyStatsObject) {
        this.revenuePerEmployeeTrailingTwelveMonths = keyStatsObject.getRevenuePerEmployee();
    }

    public BigDecimal getReturnOnAssetsTrailingTwelveMonths() {
        return returnOnAssetsTrailingTwelveMonths;
    }

    public void setReturnOnAssetsTrailingTwelveMonths(KeyStatsObject keyStatsObject) {
        this.returnOnAssetsTrailingTwelveMonths = keyStatsObject.getReturnOnAssets();
    }

    public BigDecimal getReturnOnCapitalTrailingTwelveMonths() {
        return returnOnCapitalTrailingTwelveMonths;
    }

    public void setReturnOnCapitalTrailingTwelveMonths(KeyStatsObject keyStatsObject) {
        this.returnOnCapitalTrailingTwelveMonths = keyStatsObject.getReturnOnCapital();
    }

    public BigDecimal getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(KeyStatsObject keyStatsObject) {
        this.profitMargin = keyStatsObject.getProfitMargin();
    }

    public BigDecimal getPriceToSales() {
        return priceToSales;
    }

    public void setPriceToSales(KeyStatsObject keyStatsObject) {
        this.priceToSales = keyStatsObject.getPriceToSales();
    }

    public BigDecimal getPriceToBook() {
        return priceToBook;
    }

    public void setPriceToBook(KeyStatsObject keyStatsObject) {
        this.priceToBook = keyStatsObject.getPriceToBook();
    }


    private BigDecimal getCurrentRatio() {
        return currentRatio;
    }

    private void setCurrentRatio(Financials financials) {
        System.err.println("setCurrentRatio");
        System.err.println("currentAssets: " + financials.getCurrentAssets());
        System.err.println("CurrentDebt: " + financials.getCurrentDebt() );
        if (financials.getCurrentAssets() != null && financials.getCurrentDebt() != null) {
            currentRatio = financials.getCurrentAssets().divide(financials.getCurrentDebt(),5, RoundingMode.HALF_UP);
        }
    }

    private BigDecimal getCashRatio() {
        return cashRatio;
    }

    private void setCashRatio(Financials financials) {
        System.err.println("setCashRatio");
        System.err.println("TotalCash: " + financials.getTotalCash());
        System.err.println("CurrentDebt: " + financials.getCurrentDebt());
        if (financials.getTotalCash() != null && financials.getCurrentDebt() != null) {
            cashRatio = financials.getTotalCash().divide(financials.getCurrentDebt(),5, RoundingMode.HALF_UP);
        }

    }

    private BigDecimal getOperatingCashFlowRatio() {
        return operatingCashFlowRatio;
    }

    private void setOperatingCashFlowRatio(Financials financials) {
        System.err.println("setOperatingCashFlowRatio");
        System.err.println("OperatingRevenue: " + financials.getOperatingRevenue());
        System.err.println("CurrentDebt: " + financials.getCurrentDebt());
        if (financials.getOperatingRevenue() != null && financials.getCurrentDebt() != null) {
            operatingCashFlowRatio = financials.getOperatingRevenue().divide(financials.getCurrentDebt(),5, RoundingMode.HALF_UP);
        }
    }

    private BigDecimal getDebtRatio() {
        return debtRatio;
    }

    private void setDebtRatio(Financials financials) {
        System.err.println("setDebtRatio");
        System.err.println("TotalDebt: " + financials.getTotalDebt());
        System.err.println("TotalAssets: " + financials.getTotalAssets());
        if (financials.getTotalDebt() != null && financials.getTotalAssets() != null) {
            debtRatio = financials.getTotalDebt().divide(financials.getTotalAssets(),5, RoundingMode.HALF_UP);
        }
    }

    private BigDecimal getDebtToEquityRatio() {
        return debtToEquityRatio;
    }

    private void setDebtToEquityRatio(Financials financials) {
        System.err.println("setDebtToEquityRatio");
        System.err.println("TotalDebt: " + financials.getTotalDebt());
        System.err.println("ShareholderEquity: " + financials.getShareholderEquity());
        if (financials.getTotalDebt() != null && financials.getShareholderEquity() != null) {
            debtToEquityRatio = financials.getTotalDebt().divide(financials.getShareholderEquity(),5, RoundingMode.HALF_UP);
        }
    }

    private BigDecimal getDebtServiceCoverageRatio() {
        return debtServiceCoverageRatio;
    }

    private void setDebtServiceCoverageRatio(Financials financials) {
        System.err.println("setDebtServiceCoverageRatio");
        System.err.println("OperatingRevenue: " + financials.getOperatingRevenue());
        System.err.println("TotalDebt: " + financials.getTotalDebt());
        if (financials.getOperatingRevenue() != null && financials.getTotalDebt() != null) {
            debtServiceCoverageRatio = financials.getOperatingRevenue().divide(financials.getTotalDebt(),5, RoundingMode.HALF_UP);
        }
    }

    private BigDecimal getAssetTurnoverRatio() {
        return assetTurnoverRatio;
    }

    private void setAssetTurnoverRatio(Financials financials) {
        System.err.println("setAssetTurnoverRatio");
        System.err.println("TotalRevenue: " + financials.getTotalRevenue());
        System.err.println("TotalAssets: " + financials.getTotalAssets());
        if (financials.getTotalRevenue() != null && financials.getTotalAssets() != null) {
            assetTurnoverRatio = financials.getTotalRevenue().divide(financials.getTotalAssets(), 5, RoundingMode.HALF_UP);
        }
    }

    private BigDecimal getGrossMarginRatio() {
        return grossMarginRatio;
    }

    private void setGrossMarginRatio(Financials financials) {
        System.err.println("setGrossMarginRatio");
        System.err.println("GrossProfit: " + financials.getGrossProfit());
        System.err.println("TotalRevenue: " + financials.getTotalRevenue());
        if (financials.getGrossProfit() != null && financials.getTotalRevenue() != null) {
            grossMarginRatio = financials.getGrossProfit().divide(financials.getTotalRevenue(),5, RoundingMode.HALF_UP);
        }
    }

    private BigDecimal getOperatingMarginRatio() {
        return operatingMarginRatio;
    }

    private void setOperatingMarginRatio(Financials financials) {
        System.err.println("setOperatingMarginRatio");
        System.err.println("OperatingRevenue: " + financials.getOperatingRevenue());
        System.err.println("TotalRevenue: " + financials.getTotalRevenue());
        if (financials.getOperatingRevenue() != null && financials.getTotalRevenue() != null) {
            operatingMarginRatio = financials.getOperatingRevenue().divide(financials.getTotalRevenue(),5, RoundingMode.HALF_UP);
        }
    }

    private BigDecimal getReturnOnAssetsRatio() {
        return returnOnAssetsRatio;

    }

    private void setReturnOnAssetsRatio(Financials financials) {
        System.err.println("setReturnOnAssetsRatio");
        System.err.println("NetIncome: " + financials.getNetIncome());
        System.err.println("TotalAssets: " + financials.getTotalAssets());
        if (financials.getNetIncome() != null && financials.getTotalAssets() != null) {
            returnOnAssetsRatio = financials.getNetIncome().divide(financials.getTotalAssets(),5, RoundingMode.HALF_UP);
        }
    }

    private BigDecimal getReturnOnEquityRatio() {
        return returnOnEquityRatio;
    }

    private void setReturnOnEquityRatio(Financials financials, KeyStatsObject keyStatsObject) {
        System.err.println("setReturnOnEquityRatio");
        System.err.println("NetIncome: " + financials.getNetIncome());
        System.err.println("ShareholderEquity: " + financials.getShareholderEquity());
        if(financials.getNetIncome() != null && financials.getShareholderEquity() != null)
        returnOnEquityRatio = financials.getNetIncome().divide(financials.getShareholderEquity(), 5, RoundingMode.HALF_UP);

    }

    public void setRatios(Financials financials, KeyStatsObject keyStatsObject)
    {
        setMarketcap(keyStatsObject);
        setDividendRate(keyStatsObject);
        setDividendYield(keyStatsObject);
        setCashTrailingTwelveMonths(keyStatsObject);
        setDebtTrailingTwelveMonths(keyStatsObject);
        setRevenuePerShareTrailingTwelveMonths(keyStatsObject);
        setRevenuePerEmployeeTrailingTwelveMonths(keyStatsObject);
        setReturnOnAssetsTrailingTwelveMonths(keyStatsObject);
        setReturnOnCapitalTrailingTwelveMonths(keyStatsObject);
        setProfitMargin(keyStatsObject);
        setPriceToSales(keyStatsObject);
        setPriceToBook(keyStatsObject);
        setCurrentRatio(financials);
        setCashRatio(financials);
        setOperatingCashFlowRatio(financials);
        setDebtRatio(financials);
        setDebtToEquityRatio(financials);
        setDebtServiceCoverageRatio(financials);
        setAssetTurnoverRatio(financials);
        setGrossMarginRatio(financials);
        setOperatingMarginRatio(financials);
        setReturnOnAssetsRatio(financials);
        setReturnOnEquityRatio(financials, keyStatsObject);
    }

    public Map<String, BigDecimal> getRatios()
    {
        ratios = new HashMap<>();
        ratios.put("MarketCap", getMarketCap());
        ratios.put("DividendRate", getDividendRate());
        ratios.put("DividendYield", getDividendYield());
        ratios.put("CashTrailing12Months",getCashTrailingTwelveMonths());
        ratios.put("DebtTrailing12Months",getDebtTrailingTwelveMonths());
        ratios.put("RevenuePerShareTrailing12Months", getRevenuePerShareTrailingTwelveMonths());
        ratios.put("RevenuePerEmployeeTrailing12Months", getRevenuePerEmployeeTrailingTwelveMonths());
        ratios.put("ReturnOnAssetsTrailing12Months", getReturnOnAssetsTrailingTwelveMonths());
        ratios.put("ReturnOnCapitalTrailing12Months", getReturnOnCapitalTrailingTwelveMonths());
        ratios.put("ProfitMargin", getProfitMargin());
        ratios.put("PriceToSales", getPriceToSales());
        ratios.put("PriceToBook", getPriceToBook());
        ratios.put("CurrentRatio", getCurrentRatio());
        ratios.put("CashRatio", getCashRatio());
        ratios.put("OperatingCashFlowRatio", getOperatingCashFlowRatio());
        ratios.put("DebtRatio", getDebtRatio());
        ratios.put("DebtToEquityRatio", getDebtToEquityRatio());
        ratios.put("DebtServiceCoverageRatio", getDebtServiceCoverageRatio());
        ratios.put("AssetTurnoverRatio", getAssetTurnoverRatio());
        ratios.put("GrossMarginRatio", getGrossMarginRatio());
        ratios.put("OperatingMarginRatio", getOperatingMarginRatio());
        ratios.put("ReturnOnAssetsRatio", getReturnOnAssetsRatio());
        ratios.put("ReturnOnEquityRatio", getReturnOnEquityRatio());
        return ratios;
    }
}