package com.sherlock.jdbc;


import com.sherlock.model.ResponseObject;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ResponseObjectRowMapper implements RowMapper<ResponseObject> {
    @Override
    public ResponseObject mapRow(ResultSet rs, int i) throws SQLException {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setREPORT_DATE(rs.getString("REPORT_DATE"));
        responseObject.setCOMPANY_NAME(rs.getString("COMPANY_NAME"));
        responseObject.setTICKER_SYMBOL(rs.getString("TICKER_SYMBOL"));
        responseObject.setGROSS_PROFIT(rs.getBigDecimal("GROSS_PROFIT"));
        responseObject.setCOST_OF_REVENUE(rs.getBigDecimal("COST_OF_REVENUE"));
        responseObject.setOPERATING_REVENUE(rs.getBigDecimal("OPERATING_REVENUE"));
        responseObject.setTOTAL_REVENUE(rs.getBigDecimal("TOTAL_REVENUE"));
        responseObject.setOPERATING_INCOME(rs.getBigDecimal("OPERATING_INCOME"));
        responseObject.setNET_INCOME(rs.getBigDecimal("NET_INCOME"));
        responseObject.setRESEARCH_AND_DEVELOPMENT(rs.getBigDecimal("RESEARCH_AND_DEVELOPMENT"));
        responseObject.setOPERATING_EXPENSES(rs.getBigDecimal("OPERATING_EXPENSES"));
        responseObject.setCURRENT_ASSETS(rs.getBigDecimal("CURRENT_ASSETS"));
        responseObject.setTOTAL_ASSETS(rs.getBigDecimal("TOTAL_ASSETS"));
        responseObject.setTOTAL_LIABILITIES(rs.getBigDecimal("TOTAL_LIABILITIES"));
        responseObject.setCURRENT_CASH(rs.getBigDecimal("CURRENT_CASH"));
        responseObject.setCURRENT_DEBT(rs.getBigDecimal("CURRENT_DEBT"));
        responseObject.setTOTAL_CASH(rs.getBigDecimal("TOTAL_CASH"));
        responseObject.setTOTAL_DEBT(rs.getBigDecimal("TOTAL_DEBT"));
        responseObject.setSHARE_HOLDER_EQUITY(rs.getBigDecimal("SHARE_HOLDER_EQUITY"));
        responseObject.setCASH_CHANGE(rs.getBigDecimal("CASH_CHANGE"));
        responseObject.setCASH_FLOW(rs.getBigDecimal("CASH_FLOW"));
        responseObject.setOPERATING_GAINS_LOSSES(rs.getBigDecimal("OPERATING_GAINS_LOSSES"));

        responseObject.setMARKET_CAP(rs.getBigDecimal("MARKET_CAP"));
        responseObject.setDIVIDEND_RATE(rs.getBigDecimal("DIVIDEND_RATE"));
        responseObject.setDIVIDEND_YIELD(rs.getBigDecimal("DIVIDEND_YIELD"));
        responseObject.setCASH_TRAILING_TWELVE_MONTHS(rs.getBigDecimal("CASH_TRAILING_TWELVE_MONTHS"));
        responseObject.setDEBT_TRAILING_TWELVE_MONTHS(rs.getBigDecimal("DEBT_TRAILING_TWELVE_MONTHS"));
        responseObject.setREVENUE_PER_SHARE_TRAILING_TWELVE_MONTHS(rs.getBigDecimal("REVENUE_PER_SHARE_TRAILING_TWELVE_MONTHS"));
        responseObject.setREVENUE_PER_EMPLOYEE_TRAILING_TWELVE_MONTHS(rs.getBigDecimal("REVENUE_PER_EMPLOYEE_TRAILING_TWELVE_MONTHS"));
        responseObject.setRETURN_ON_ASSETS_TRAILING_TWELVE_MONTHS(rs.getBigDecimal("RETURN_ON_ASSETS_TRAILING_TWELVE_MONTHS"));
        responseObject.setRETURN_ON_CAPITAL_TRAILING_TWELVE_MONTHS(rs.getBigDecimal("RETURN_ON_CAPITAL_TRAILING_TWELVE_MONTHS"));
        responseObject.setPROFIT_MARGIN(rs.getBigDecimal("PROFIT_MARGIN"));
        responseObject.setPRICE_TO_SALES(rs.getBigDecimal("PRICE_TO_SALES"));
        responseObject.setPRICE_TO_BOOK(rs.getBigDecimal("PRICE_TO_BOOK"));

        responseObject.setCURRENT_RATIO(rs.getBigDecimal("CURRENT_RATIO"));
        responseObject.setCASH_RATIO(rs.getBigDecimal("CASH_RATIO"));
        responseObject.setOPERATING_CASH_FLOW_RATIO(rs.getBigDecimal("OPERATING_CASH_FLOW_RATIO"));
        responseObject.setDEBT_RATIO(rs.getBigDecimal("DEBT_RATIO"));
        responseObject.setDEBT_TO_EQUITY_RATIO(rs.getBigDecimal("DEBT_TO_EQUITY_RATIO"));
        responseObject.setDEBT_SERVICE_COVERAGE_RATIO(rs.getBigDecimal("DEBT_SERVICE_COVERAGE_RATIO"));
        responseObject.setASSET_TURNOVER_RATIO(rs.getBigDecimal("ASSET_TURNOVER_RATIO"));
        responseObject.setGROSS_MARGIN_RATIO(rs.getBigDecimal("GROSS_MARGIN_RATIO"));
        responseObject.setOPERATING_MARGIN_RATIO(rs.getBigDecimal("OPERATING_MARGIN_RATIO"));
        responseObject.setRETURN_ON_ASSETS_RATIO(rs.getBigDecimal("RETURN_ON_ASSETS_RATIO"));
        responseObject.setRETURN_ON_EQUITY_RATIO(rs.getBigDecimal("RETURN_ON_EQUITY_RATIO"));

        return responseObject;
    }
}
