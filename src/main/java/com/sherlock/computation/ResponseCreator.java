package com.sherlock.computation;

import com.sherlock.iex.IexApiCalls;
import com.sherlock.model.FinancialDataObject;
import com.sherlock.model.Financials;
import com.sherlock.model.KeyStatsObject;
import com.sherlock.model.ResponseObject;
import com.sherlock.validation.Validation;

import java.math.BigDecimal;

/**
 * This class is a data extractor and manipulator
 * it makes the call 2 calls iex API and one for
 * 1-to retrieve financials
 * 2-to retrieve key stats
 */
public class ResponseCreator {

    public ResponseObject create(String ticker)
    {
        IexApiCalls iexApiCalls = new IexApiCalls();
        FinancialDataObject financialDataObjectArray = iexApiCalls.getFinancials(ticker);
        KeyStatsObject keyStatsObject = iexApiCalls.getKeyStats(ticker);

        Ratios ratios = new Ratios();
        ratios.setRatios(financialDataObjectArray.getFinancials()[0]);

        return map(financialDataObjectArray.getFinancials()[0], keyStatsObject, ratios, ticker);

    }

    /**
     * This method maps the response from the 2 iex API calls
     * to our response object
     * @param financials
     * @param keyStatsObject
     * @param ratios
     * @param ticker
     * @return ResponseObject
     */
    private ResponseObject map(Financials financials, KeyStatsObject keyStatsObject, Ratios ratios, String ticker)
    {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setREPORT_DATE(financials.getReportDate());
        responseObject.setCOMPANY_NAME(keyStatsObject.getCompanyName());
        responseObject.setTICKER_SYMBOL(ticker);
        responseObject.setGROSS_PROFIT(Validation.isNumeric(financials.getGrossProfit()) ? new BigDecimal(financials.getGrossProfit()) : BigDecimal.ZERO);
        responseObject.setCOST_OF_REVENUE(Validation.isNumeric(financials.getCostOfRevenue()) ? new BigDecimal(financials.getCostOfRevenue()) : BigDecimal.ZERO);
        responseObject.setOPERATING_REVENUE(Validation.isNumeric(financials.getOperatingRevenue()) ? new BigDecimal(financials.getOperatingRevenue()) : BigDecimal.ZERO);
        responseObject.setTOTAL_REVENUE(Validation.isNumeric(financials.getTotalRevenue()) ? new BigDecimal(financials.getTotalRevenue()) : BigDecimal.ZERO);
        responseObject.setOPERATING_INCOME(Validation.isNumeric(financials.getOperatingIncome()) ? new BigDecimal(financials.getOperatingIncome()) : BigDecimal.ZERO);
        responseObject.setNET_INCOME(Validation.isNumeric(financials.getNetIncome()) ? new BigDecimal(financials.getNetIncome()) : BigDecimal.ZERO);
        responseObject.setRESEARCH_AND_DEVELOPMENT(Validation.isNumeric(financials.getResearchAndDevelopment()) ? new BigDecimal(financials.getResearchAndDevelopment()) : BigDecimal.ZERO);
        responseObject.setOPERATING_EXPENSES(Validation.isNumeric(financials.getOperatingExpense()) ? new BigDecimal(financials.getOperatingExpense()) : BigDecimal.ZERO);
        responseObject.setCURRENT_ASSETS(Validation.isNumeric(financials.getCurrentAssets()) ? new BigDecimal(financials.getCurrentAssets()) : BigDecimal.ZERO);
        responseObject.setTOTAL_ASSETS(Validation.isNumeric(financials.getTotalAssets()) ? new BigDecimal(financials.getTotalAssets()) : BigDecimal.ZERO);
        responseObject.setTOTAL_LIABILITIES(Validation.isNumeric(financials.getTotalLiabilities()) ? new BigDecimal(financials.getTotalLiabilities()) : BigDecimal.ZERO);
        responseObject.setCURRENT_CASH(Validation.isNumeric(financials.getCurrentCash()) ? new BigDecimal(financials.getCurrentCash()) : BigDecimal.ZERO);
        responseObject.setCURRENT_DEBT(Validation.isNumeric(financials.getCurrentDebt()) ? new BigDecimal(financials.getCurrentDebt()) : BigDecimal.ZERO);
        responseObject.setTOTAL_CASH(Validation.isNumeric(financials.getTotalCash()) ? new BigDecimal(financials.getTotalCash()) : BigDecimal.ZERO);
        responseObject.setTOTAL_DEBT(Validation.isNumeric(financials.getTotalDebt()) ? new BigDecimal(financials.getTotalDebt()) : BigDecimal.ZERO);
        responseObject.setSHARE_HOLDER_EQUITY(Validation.isNumeric(financials.getShareholderEquity()) ? new BigDecimal(financials.getShareholderEquity()) : BigDecimal.ZERO);
        responseObject.setCASH_CHANGE(Validation.isNumeric(financials.getCashChange()) ? new BigDecimal(financials.getCashChange()) : BigDecimal.ZERO);
        responseObject.setCASH_FLOW(Validation.isNumeric(financials.getCashFlow()) ? new BigDecimal(financials.getCashFlow()) : BigDecimal.ZERO);
        responseObject.setOPERATING_GAINS_LOSSES(Validation.isNumeric(financials.getOperatingGainsLosses()) ? new BigDecimal(financials.getOperatingGainsLosses()) : BigDecimal.ZERO);

        responseObject.setMARKET_CAP(Validation.isNumeric(keyStatsObject.getMarketcap()) ? new BigDecimal(keyStatsObject.getMarketcap()) : BigDecimal.ZERO);
        responseObject.setDIVIDEND_RATE(Validation.isNumeric(keyStatsObject.getDividendRate()) ? new BigDecimal(keyStatsObject.getDividendRate()) : BigDecimal.ZERO);
        responseObject.setDIVIDEND_YIELD(Validation.isNumeric(keyStatsObject.getDividendYield()) ? new BigDecimal(keyStatsObject.getDividendYield()) : BigDecimal.ZERO);
        responseObject.setCASH_TRAILING_TWELVE_MONTHS(Validation.isNumeric(keyStatsObject.getCash()) ? new BigDecimal(keyStatsObject.getCash()) : BigDecimal.ZERO);
        responseObject.setDEBT_TRAILING_TWELVE_MONTHS(Validation.isNumeric(keyStatsObject.getDebt()) ? new BigDecimal(keyStatsObject.getDebt()) : BigDecimal.ZERO);
        responseObject.setREVENUE_PER_SHARE_TRAILING_TWELVE_MONTHS(Validation.isNumeric(keyStatsObject.getRevenuePerShare()) ? new BigDecimal(keyStatsObject.getRevenuePerShare()) : BigDecimal.ZERO);
        responseObject.setREVENUE_PER_EMPLOYEE_TRAILING_TWELVE_MONTHS(Validation.isNumeric(keyStatsObject.getRevenuePerEmployee()) ? new BigDecimal(keyStatsObject.getRevenuePerEmployee()) : BigDecimal.ZERO);
        responseObject.setRETURN_ON_ASSETS_TRAILING_TWELVE_MONTHS(Validation.isNumeric(keyStatsObject.getReturnOnAssets()) ? new BigDecimal(keyStatsObject.getReturnOnAssets()) : BigDecimal.ZERO);
        responseObject.setRETURN_ON_CAPITAL_TRAILING_TWELVE_MONTHS(Validation.isNumeric(keyStatsObject.getReturnOnCapital()) ? new BigDecimal(keyStatsObject.getReturnOnCapital()) : BigDecimal.ZERO);
        responseObject.setPROFIT_MARGIN(Validation.isNumeric(keyStatsObject.getProfitMargin()) ? new BigDecimal(keyStatsObject.getProfitMargin()) : BigDecimal.ZERO);
        responseObject.setPRICE_TO_SALES(Validation.isNumeric(keyStatsObject.getPriceToSales()) ? new BigDecimal(keyStatsObject.getPriceToSales()) : BigDecimal.ZERO);
        responseObject.setPRICE_TO_BOOK(Validation.isNumeric(keyStatsObject.getPriceToBook()) ? new BigDecimal(keyStatsObject.getPriceToBook()) : BigDecimal.ZERO);

        responseObject.setCURRENT_RATIO(ratios.getCurrentRatio());
        responseObject.setCASH_RATIO(ratios.getCashRatio());
        responseObject.setOPERATING_CASH_FLOW_RATIO(ratios.getOperatingCashFlowRatio());
        responseObject.setDEBT_RATIO(ratios.getDebtRatio());
        responseObject.setDEBT_TO_EQUITY_RATIO(ratios.getDebtToEquityRatio());
        responseObject.setDEBT_SERVICE_COVERAGE_RATIO(ratios.getDebtServiceCoverageRatio());
        responseObject.setASSET_TURNOVER_RATIO(ratios.getAssetTurnoverRatio());
        responseObject.setGROSS_MARGIN_RATIO(ratios.getGrossMarginRatio());
        responseObject.setOPERATING_MARGIN_RATIO(ratios.getOperatingMarginRatio());
        responseObject.setRETURN_ON_ASSETS_RATIO(ratios.getReturnOnAssetsRatio());
        responseObject.setRETURN_ON_EQUITY_RATIO(ratios.getReturnOnEquityRatio());

        return responseObject;
    }
}
