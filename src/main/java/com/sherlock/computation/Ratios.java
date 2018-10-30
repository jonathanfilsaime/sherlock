package com.sherlock.computation;

import com.sherlock.model.Financials;
import com.sherlock.validation.Validation;

import java.math.BigDecimal;

public class Ratios {

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


    public BigDecimal getCurrentRatio() {
        return currentRatio;
    }

    public BigDecimal getCashRatio() {
        return cashRatio;
    }

    public BigDecimal getOperatingCashFlowRatio() {
        return operatingCashFlowRatio;
    }

    public BigDecimal getDebtRatio() {
        return debtRatio;
    }

    public BigDecimal getDebtToEquityRatio() {
        return debtToEquityRatio;
    }

    public BigDecimal getDebtServiceCoverageRatio() {
        return debtServiceCoverageRatio;
    }

    public BigDecimal getAssetTurnoverRatio() {
        return assetTurnoverRatio;
    }

    public BigDecimal getGrossMarginRatio() {
        return grossMarginRatio;
    }

    public BigDecimal getOperatingMarginRatio() {
        return operatingMarginRatio;
    }

    public BigDecimal getReturnOnAssetsRatio() {
        return returnOnAssetsRatio;
    }

    public BigDecimal getReturnOnEquityRatio() {
        return returnOnEquityRatio;
    }

    private void setCurrentRatio(Financials financials) {
        if(Validation.isNumeric(financials.getCurrentAssets()) && Validation.isNumeric(financials.getCurrentDebt()))
        {
            this.currentRatio = Operation.divide(financials.getCurrentAssets(), financials.getCurrentDebt());
        }
    }

    private void setCashRatio(Financials financials) {
        if(Validation.isNumeric(financials.getCurrentCash()) && Validation.isNumeric(financials.getCurrentDebt()))
        {
            this.cashRatio = Operation.divide(financials.getCurrentCash(), financials.getCurrentDebt());
        }
    }

    private void setOperatingCashFlowRatio(Financials financials) {
        if(Validation.isNumeric(financials.getCashFlow()) && Validation.isNumeric(financials.getCurrentDebt()))
        {
            this.operatingCashFlowRatio = Operation.divide(financials.getCashFlow(),financials.getCurrentDebt());
        }
    }

    private void setDebtRatio(Financials financials) {
        if(Validation.isNumeric(financials.getTotalLiabilities()) && Validation.isNumeric(financials.getTotalAssets()))
        {
            this.debtRatio = Operation.divide(financials.getTotalLiabilities(), financials.getTotalAssets());
        }
    }

    private void setDebtToEquityRatio(Financials financials) {
        if(Validation.isNumeric(financials.getTotalLiabilities()) && Validation.isNumeric(financials.getShareholderEquity()))
        {
            this.debtToEquityRatio = Operation.divide(financials.getTotalLiabilities(), financials.getShareholderEquity());
        }
    }

    private void setDebtServiceCoverageRatio(Financials financials) {
        if(Validation.isNumeric(financials.getOperatingIncome()) && Validation.isNumeric(financials.getTotalDebt()))
        {
            this.debtServiceCoverageRatio = Operation.divide(financials.getOperatingIncome(), financials.getTotalDebt());
        }
    }

    private void setAssetTurnoverRatio(Financials financials) {
        if(Validation.isNumeric(financials.getTotalRevenue()) && Validation.isNumeric(financials.getTotalAssets()))
        {
            this.assetTurnoverRatio = Operation.divide(financials.getTotalRevenue(), financials.getTotalAssets());
        }
    }

    private void setGrossMarginRatio(Financials financials) {
        if(Validation.isNumeric(financials.getGrossProfit()) && Validation.isNumeric(financials.getTotalRevenue()))
        {
            this.grossMarginRatio = Operation.divide(financials.getGrossProfit(), financials.getTotalRevenue());
        }
    }

    private void setOperatingMarginRatio(Financials financials) {
        if(Validation.isNumeric(financials.getOperatingIncome()) && Validation.isNumeric(financials.getTotalRevenue()))
        {
            this.operatingMarginRatio = Operation.divide(financials.getOperatingIncome(), financials.getTotalRevenue());
        }
    }

    private void setReturnOnAssetsRatio(Financials financials) {
        if(Validation.isNumeric(financials.getNetIncome()) && Validation.isNumeric(financials.getTotalAssets()))
        {
            this.returnOnAssetsRatio = Operation.divide(financials.getNetIncome(), financials.getTotalAssets());
        }
    }

    private void setReturnOnEquityRatio(Financials financials) {
        if(Validation.isNumeric(financials.getNetIncome()) & Validation.isNumeric(financials.getShareholderEquity()))
        {
            this.returnOnEquityRatio = Operation.divide(financials.getNetIncome(), financials.getShareholderEquity());
        }
    }

    public void setRatios(Financials financials)
    {
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
        setReturnOnEquityRatio(financials);
    }
}
