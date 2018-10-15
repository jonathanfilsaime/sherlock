package com.sherlock.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@Table(name = "FINANCIAL_DATA")
public class ResponseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String REPORT_DATE;
    private String COMPANY_NAME;
    private String TICKER_SYMBOL;
    private BigDecimal GROSS_PROFIT;
    private BigDecimal COST_OF_REVENUE;
    private BigDecimal OPERATING_REVENUE;
    private BigDecimal TOTAL_REVENUE;
    private BigDecimal OPERATING_INCOME;
    private BigDecimal NET_INCOME;
    private BigDecimal RESEARCH_AND_DEVELOPMENT;
    private BigDecimal OPERATING_EXPENSES;
    private BigDecimal CURRENT_ASSETS;
    private BigDecimal TOTAL_ASSETS;
    private BigDecimal TOTAL_LIABILITIES;
    private BigDecimal CURRENT_CASH;
    private BigDecimal CURRENT_DEBT;
    private BigDecimal TOTAL_CASH;
    private BigDecimal TOTAL_DEBT;
    private BigDecimal SHARE_HOLDER_EQUITY;
    private BigDecimal CASH_CHANGE;
    private BigDecimal CASH_FLOW;
    private BigDecimal OPERATING_GAINS_LOSSES;
    private BigDecimal MARKET_CAP;
    private BigDecimal DIVIDEND_RATE;
    private BigDecimal DIVIDEND_YIELD;
    private BigDecimal CASH_TRAILING_TWELVE_MONTHS;
    private BigDecimal DEBT_TRAILING_TWELVE_MONTHS;
    private BigDecimal REVENUE_PER_SHARE_TRAILING_TWELVE_MONTHS;
    private BigDecimal REVENUE_PER_EMPLOYEE_TRAILING_TWELVE_MONTHS;
    private BigDecimal RETURN_ON_ASSETS_TRAILING_TWELVE_MONTHS;
    private BigDecimal RETURN_ON_CAPITAL_TRAILING_TWELVE_MONTHS;
    private BigDecimal PROFIT_MARGIN;
    private BigDecimal PRICE_TO_SALES;
    private BigDecimal PRICE_TO_BOOK;
    private BigDecimal CURRENT_RATIO;
    private BigDecimal CASH_RATIO;
    private BigDecimal OPERATING_CASH_FLOW_RATIO;
    private BigDecimal DEBT_RATIO;
    private BigDecimal DEBT_TO_EQUITY_RATIO;
    private BigDecimal DEBT_SERVICE_COVERAGE_RATIO;
    private BigDecimal ASSET_TURNOVER_RATIO;
    private BigDecimal GROSS_MARGIN_RATIO;
    private BigDecimal OPERATING_MARGIN_RATIO;
    private BigDecimal RETURN_ON_ASSETS_RATIO;
    private BigDecimal RETURN_ON_EQUITY_RATIO;
}
