package com.sherlock.computation;

import java.util.ArrayList;
import java.util.List;


/**
 * {
 * "find": "string" can only be the find values specified below,
 *   "conditionRequestObjects":
 *   [{
 *       "where": "string" can only be the where values specified below,
 *       "isGreater": "string" can only be true or false,
 *       "amount": "string" example $1,000,000.00
 *     }]
 *
 * }
 */
public class SearchValues {

    private List<String> values;

    public SearchValues(){
        this.values = new ArrayList<>();
        //find: values
        values.add("TOP_10_STOCKS");
        values.add("TOP_50_STOCKS");
        values.add("TOP_100_STOCKS");

        //where: values
        values.add("ALL_STOCKS");
        values.add("REPORT_DATE");
        values.add("COMPANY_NAME");
        values.add("TICKER_SYMBOL");
        values.add("GROSS_PROFIT");
        values.add("COST_OF_REVENUE");
        values.add("OPERATING_REVENUE");
        values.add("TOTAL_REVENUE");
        values.add("OPERATING_INCOME");
        values.add("NET_INCOME");
        values.add("RESEARCH_AND_DEVELOPMENT");
        values.add("OPERATING_EXPENSES");
        values.add("CURRENT_ASSETS");
        values.add("TOTAL_ASSETS");
        values.add("TOTAL_LIABILITIES");
        values.add("CURRENT_CASH");
        values.add("CURRENT_DEBT");
        values.add("TOTAL_CASH");
        values.add("TOTAL_DEBT");
        values.add("SHARE_HOLDER_EQUITY");
        values.add("CASH_CHANGE");
        values.add("CASH_FLOW");
        values.add("OPERATING_GAINS_LOSSES");
        values.add("MARKET_CAP");
        values.add("DIVIDEND_RATE");
        values.add("DIVIDEND_YIELD");
        values.add("CASH_TRAILING_TWELVE_MONTHS");
        values.add("DEBT_TRAILING_TWELVE_MONTHS");
        values.add("REVENUE_PER_SHARE_TRAILING_TWELVE_MONTHS");
        values.add("REVENUE_PER_EMPLOYEE_TRAILING_TWELVE_MONTHS");
        values.add("RETURN_ON_ASSETS_TRAILING_TWELVE_MONTHS");
        values.add("RETURN_ON_CAPITAL_TRAILING_TWELVE_MONTHS");
        values.add("PROFIT_MARGIN");
        values.add("PRICE_TO_SALES");
        values.add("PRICE_TO_BOOK");
        values.add("CURRENT_RATIO");
        values.add("CASH_RATIO");
        values.add("OPERATING_CASH_FLOW_RATIO");
        values.add("DEBT_RATIO");
        values.add("DEBT_TO_EQUITY_RATIO");
        values.add("DEBT_SERVICE_COVERAGE_RATIO");
        values.add("ASSET_TURNOVER_RATIO");
        values.add("GROSS_MARGIN_RATIO");
        values.add("OPERATING_MARGIN_RATIO");
        values.add("RETURN_ON_ASSETS_RATIO");
        values.add("RETURN_ON_EQUITY_RATIO");
    }

    public List<String> getValues()
    {
        return this.values;
    }
}
