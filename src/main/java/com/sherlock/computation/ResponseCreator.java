package com.sherlock.computation;

import com.sherlock.iex.IexApiCalls;
import com.sherlock.model.FinancialDataObject;
import com.sherlock.model.Financials;
import com.sherlock.model.KeyStatsObject;
import com.sherlock.model.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public class ResponseCreator {

    public ResponseObject create(String ticker)
    {
        IexApiCalls iexApiCalls = new IexApiCalls();
        ResponseEntity<FinancialDataObject> financialDataObjectArray = iexApiCalls.getFinancials(ticker);
        ResponseEntity<KeyStatsObject> keyStatsObject = iexApiCalls.getKeyStats(ticker);
        Ratios ratios = new Ratios();

        if(Validation.validateFinancialDataObject(financialDataObjectArray) && Validation.validateKeyStatsObject(keyStatsObject))
        {
            ratios.setRatios(financialDataObjectArray.getBody().getFinancials()[0]);
            return map(financialDataObjectArray.getBody().getFinancials()[0], keyStatsObject.getBody(), ratios);
        }
        return null;
    }

    private ResponseObject map(Financials financials, KeyStatsObject keyStatsObject, Ratios ratios)
    {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setReportDate(financials.getReportDate());
        responseObject.setGrossProfit(Validation.isNumeric(financials.getGrossProfit()) ? new BigDecimal(financials.getGrossProfit()) : BigDecimal.ZERO);
        responseObject.setCostOfRevenue(Validation.isNumeric(financials.getCostOfRevenue()) ? new BigDecimal(financials.getCostOfRevenue()) : BigDecimal.ZERO);
        responseObject.setOperatingRevenue(Validation.isNumeric(financials.getOperatingRevenue()) ? new BigDecimal(financials.getOperatingRevenue()) : BigDecimal.ZERO);
        responseObject.setTotalRevenue(Validation.isNumeric(financials.getTotalRevenue()) ? new BigDecimal(financials.getTotalRevenue()) : BigDecimal.ZERO);
        responseObject.setOperatingIncome(Validation.isNumeric(financials.getOperatingIncome()) ? new BigDecimal(financials.getOperatingIncome()) : BigDecimal.ZERO);
        responseObject.setNetIncome(Validation.isNumeric(financials.getNetIncome()) ? new BigDecimal(financials.getNetIncome()) : BigDecimal.ZERO);
        responseObject.setResearchAndDevelopment(Validation.isNumeric(financials.getResearchAndDevelopment()) ? new BigDecimal(financials.getResearchAndDevelopment()) : BigDecimal.ZERO);
        responseObject.setOperatingExpense(Validation.isNumeric(financials.getOperatingExpense()) ? new BigDecimal(financials.getOperatingExpense()) : BigDecimal.ZERO);
        responseObject.setCurrentAssets(Validation.isNumeric(financials.getCurrentAssets()) ? new BigDecimal(financials.getCurrentAssets()) : BigDecimal.ZERO);
        responseObject.setTotalAssets(Validation.isNumeric(financials.getTotalAssets()) ? new BigDecimal(financials.getTotalAssets()) : BigDecimal.ZERO);
        responseObject.setTotalLiabilities(Validation.isNumeric(financials.getTotalLiabilities()) ? new BigDecimal(financials.getTotalLiabilities()) : BigDecimal.ZERO);
        responseObject.setCurrentCash(Validation.isNumeric(financials.getCurrentCash()) ? new BigDecimal(financials.getCurrentCash()) : BigDecimal.ZERO);
        responseObject.setCurrentDebt(Validation.isNumeric(financials.getCurrentDebt()) ? new BigDecimal(financials.getCurrentDebt()) : BigDecimal.ZERO);
        responseObject.setTotalCash(Validation.isNumeric(financials.getTotalCash()) ? new BigDecimal(financials.getTotalCash()) : BigDecimal.ZERO);
        responseObject.setTotalDebt(Validation.isNumeric(financials.getTotalDebt()) ? new BigDecimal(financials.getTotalDebt()) : BigDecimal.ZERO);
        responseObject.setShareholderEquity(Validation.isNumeric(financials.getShareholderEquity()) ? new BigDecimal(financials.getShareholderEquity()) : BigDecimal.ZERO);
        responseObject.setCashChange(Validation.isNumeric(financials.getCashChange()) ? new BigDecimal(financials.getCashChange()) : BigDecimal.ZERO);
        responseObject.setCashFlow(Validation.isNumeric(financials.getCashFlow()) ? new BigDecimal(financials.getCashFlow()) : BigDecimal.ZERO);
        responseObject.setOperatingGainsLosses(Validation.isNumeric(financials.getOperatingGainsLosses()) ? new BigDecimal(financials.getOperatingGainsLosses()) : BigDecimal.ZERO);

        responseObject.setMarketcap(Validation.isNumeric(keyStatsObject.getMarketcap()) ? new BigDecimal(keyStatsObject.getMarketcap()) : BigDecimal.ZERO);
        responseObject.setDividendRate(Validation.isNumeric(keyStatsObject.getDividendRate()) ? new BigDecimal(keyStatsObject.getDividendRate()) : BigDecimal.ZERO);
        responseObject.setDividendYield(Validation.isNumeric(keyStatsObject.getDividendYield()) ? new BigDecimal(keyStatsObject.getDividendYield()) : BigDecimal.ZERO);
        responseObject.setCashTrailingTwelveMonths(Validation.isNumeric(keyStatsObject.getCash()) ? new BigDecimal(keyStatsObject.getCash()) : BigDecimal.ZERO);
        responseObject.setDebtTrailingTwelveMonths(Validation.isNumeric(keyStatsObject.getDebt()) ? new BigDecimal(keyStatsObject.getDebt()) : BigDecimal.ZERO);
        responseObject.setRevenuePerShareTrailingTwelveMonths(Validation.isNumeric(keyStatsObject.getRevenuePerShare()) ? new BigDecimal(keyStatsObject.getRevenuePerShare()) : BigDecimal.ZERO);
        responseObject.setRevenuePerEmployeeTrailingTwelveMonths(Validation.isNumeric(keyStatsObject.getRevenuePerEmployee()) ? new BigDecimal(keyStatsObject.getRevenuePerEmployee()) : BigDecimal.ZERO);
        responseObject.setReturnOnAssetsRatio(Validation.isNumeric(keyStatsObject.getReturnOnAssets()) ? new BigDecimal(keyStatsObject.getReturnOnAssets()) : BigDecimal.ZERO);
        responseObject.setReturnOnCapitalTrailingTwelveMonths(Validation.isNumeric(keyStatsObject.getReturnOnCapital()) ? new BigDecimal(keyStatsObject.getReturnOnCapital()) : BigDecimal.ZERO);
        responseObject.setProfitMargin(Validation.isNumeric(keyStatsObject.getProfitMargin()) ? new BigDecimal(keyStatsObject.getProfitMargin()) : BigDecimal.ZERO);
        responseObject.setPriceToSales(Validation.isNumeric(keyStatsObject.getPriceToSales()) ? new BigDecimal(keyStatsObject.getPriceToSales()) : BigDecimal.ZERO);
        responseObject.setPriceToBook(Validation.isNumeric(keyStatsObject.getPriceToBook()) ? new BigDecimal(keyStatsObject.getPriceToBook()) : BigDecimal.ZERO);

        responseObject.setCurrentRatio(ratios.getCurrentRatio());
        responseObject.setCashRatio(ratios.getCashRatio());
        responseObject.setOperatingCashFlowRatio(ratios.getOperatingCashFlowRatio());
        responseObject.setDebtRatio(ratios.getDebtRatio());
        responseObject.setDebtToEquityRatio(ratios.getDebtToEquityRatio());
        responseObject.setDebtServiceCoverageRatio(ratios.getDebtServiceCoverageRatio());
        responseObject.setAssetTurnoverRatio(ratios.getAssetTurnoverRatio());
        responseObject.setGrossMarginRatio(ratios.getGrossMarginRatio());
        responseObject.setOperatingMarginRatio(ratios.getOperatingMarginRatio());
        responseObject.setReturnOnAssetsRatio(ratios.getReturnOnAssetsRatio());
        responseObject.setReturnOnEquityRatio(ratios.getReturnOnEquityRatio());

        return responseObject;
    }
}
