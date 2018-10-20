package com.sherlock.jdbc;

import com.sherlock.model.ResponseObject;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class ResponseObjectJDBCTemplate implements ResposneObjectDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(ResponseObject responseObject) {
        String SQL = "insert into FINANCIAL_DATA (REPORT_DATE, COMPANY_NAME, TICKER_SYMBOL, GROSS_PROFIT, COST_OF_REVENUE," +
                "OPERATING_REVENUE, TOTAL_REVENUE, OPERATING_INCOME, NET_INCOME, RESEARCH_AND_DEVELOPMENT, OPERATING_EXPENSES," +
                "CURRENT_ASSETS, TOTAL_ASSETS, TOTAL_LIABILITIES, CURRENT_CASH, CURRENT_DEBT, TOTAL_CASH, TOTAL_DEBT,"+
                "SHARE_HOLDER_EQUITY, CASH_CHANGE, CASH_FLOW, OPERATING_GAINS_LOSSES, MARKET_CAP, DIVIDEND_RATE, DIVIDEND_YIELD,"+
                "CASH_TRAILING_TWELVE_MONTHS, DEBT_TRAILING_TWELVE_MONTHS, REVENUE_PER_SHARE_TRAILING_TWELVE_MONTHS,"+
                "REVENUE_PER_EMPLOYEE_TRAILING_TWELVE_MONTHS, RETURN_ON_ASSETS_TRAILING_TWELVE_MONTHS,"+
                "RETURN_ON_CAPITAL_TRAILING_TWELVE_MONTHS, PROFIT_MARGIN, PRICE_TO_SALES, PRICE_TO_BOOK, CURRENT_RATIO,"+
                "CASH_RATIO, OPERATING_CASH_FLOW_RATIO, DEBT_RATIO, DEBT_TO_EQUITY_RATIO, DEBT_SERVICE_COVERAGE_RATIO,"+
                "ASSET_TURNOVER_RATIO, GROSS_MARGIN_RATIO, OPERATING_MARGIN_RATIO, RETURN_ON_ASSETS_RATIO, RETURN_ON_EQUITY_RATIO)"+
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplateObject.update(SQL, responseObject.getREPORT_DATE(), responseObject.getCOMPANY_NAME(), responseObject.getTICKER_SYMBOL(),
                responseObject.getGROSS_PROFIT(), responseObject.getCOST_OF_REVENUE(), responseObject.getOPERATING_REVENUE(),
                responseObject.getTOTAL_REVENUE(), responseObject.getOPERATING_INCOME(), responseObject.getNET_INCOME(),
                responseObject.getRESEARCH_AND_DEVELOPMENT(), responseObject.getOPERATING_EXPENSES(), responseObject.getCURRENT_ASSETS(),
                responseObject.getTOTAL_ASSETS(), responseObject.getTOTAL_LIABILITIES(), responseObject.getCURRENT_CASH(), responseObject.getCURRENT_DEBT(),
                responseObject.getTOTAL_CASH(), responseObject.getTOTAL_DEBT(), responseObject.getSHARE_HOLDER_EQUITY(), responseObject.getCASH_CHANGE(),
                responseObject.getCASH_FLOW(), responseObject.getOPERATING_GAINS_LOSSES(), responseObject.getMARKET_CAP(), responseObject.getDIVIDEND_RATE(),
                responseObject.getDIVIDEND_YIELD(), responseObject.getCASH_TRAILING_TWELVE_MONTHS(), responseObject.getDEBT_TRAILING_TWELVE_MONTHS(),
                responseObject.getREVENUE_PER_SHARE_TRAILING_TWELVE_MONTHS(), responseObject.getREVENUE_PER_EMPLOYEE_TRAILING_TWELVE_MONTHS(),
                responseObject.getRETURN_ON_ASSETS_TRAILING_TWELVE_MONTHS(), responseObject.getRETURN_ON_CAPITAL_TRAILING_TWELVE_MONTHS(),
                responseObject.getPROFIT_MARGIN(), responseObject.getPRICE_TO_SALES(), responseObject.getPRICE_TO_BOOK(), responseObject.getCURRENT_RATIO(),
                responseObject.getCASH_RATIO(), responseObject.getOPERATING_CASH_FLOW_RATIO(), responseObject.getDEBT_RATIO(),
                responseObject.getDEBT_TO_EQUITY_RATIO(), responseObject.getDEBT_SERVICE_COVERAGE_RATIO(), responseObject.getASSET_TURNOVER_RATIO(),
                responseObject.getGROSS_MARGIN_RATIO(), responseObject.getOPERATING_MARGIN_RATIO(), responseObject.getRETURN_ON_ASSETS_RATIO(),
                responseObject.getRETURN_ON_EQUITY_RATIO());

        System.err.println(responseObject);

    }

    @Override
    public Iterable<ResponseObject> query(String sql) {
        Iterable<ResponseObject> responseObjects = jdbcTemplateObject.query(sql, new ResponseObjectRowMapper());
        return responseObjects;
    }
}
