package groovy

import com.sherlock.computation.QueryParser
import com.sherlock.exception.IncorrectQuerySyntaxException
import com.sherlock.model.ConditionRequestObject
import com.sherlock.model.RequestObject
import spock.lang.Shared
import spock.lang.Specification

class QueryStringBuilderTest extends Specification {

    @Shared
    def queryParser = new QueryParser()


    def 'queryParserTest'() {
        expect:
        queryParser.queryStringBuilder(queryParser.createValueMapFromRequestObject(buildRequestObject(find, where, isGreater, amount))) == expectedResult

        where:
        find             | where                        | isGreater | amount        || expectedResult
        "TOP_10_STOCKS"  | "GROSS_PROFIT"               | "true"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE GROSS_PROFIT > 1000000 LIMIT 10;"
        "TOP_50_STOCKS"  | "COST_OF_REVENUE"            | "TRUE"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE COST_OF_REVENUE > 1000000 LIMIT 50;"
        "TOP_100_STOCKS" | "OPERATING_REVENUE"          | "True"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE OPERATING_REVENUE > 1000000 LIMIT 100;"
        "ALL_STOCKS"     | "NET_INCOME"                 | "false"   | "1,000,000"   || "SELECT * FROM financial_data WHERE NET_INCOME < 1000000;"
        "TOP_10_STOCKS"  | "RESEARCH_AND_DEVELOPMENT"   | "False"   | "01,000,000"  || "SELECT * FROM financial_data WHERE RESEARCH_AND_DEVELOPMENT < 1000000 LIMIT 10;"
        "TOP_10_STOCKS"  | "OPERATING_EXPENSES"         | "FALSE"   | "\$1000000"   || "SELECT * FROM financial_data WHERE OPERATING_EXPENSES < 1000000 LIMIT 10;"
        "TOP_10_STOCKS"  | "CURRENT_ASSETS"             | "true"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE CURRENT_ASSETS > 1000000 LIMIT 10;"
        "TOP_50_STOCKS"  | "TOTAL_ASSETS"               | "TRUE"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE TOTAL_ASSETS > 1000000 LIMIT 50;"
        "TOP_100_STOCKS" | "DIVIDEND_RATE"              | "True"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE DIVIDEND_RATE > 1000000 LIMIT 100;"
        "ALL_STOCKS"     | "CURRENT_RATIO"              | "false"   | "1,000,000"   || "SELECT * FROM financial_data WHERE CURRENT_RATIO < 1000000;"
        "TOP_10_STOCKS"  | "TOTAL_LIABILITIES"          | "False"   | "01,000,000"  || "SELECT * FROM financial_data WHERE TOTAL_LIABILITIES < 1000000 LIMIT 10;"
        "TOP_10_STOCKS"  | "CURRENT_CASH"               | "FALSE"   | "\$1000000"   || "SELECT * FROM financial_data WHERE CURRENT_CASH < 1000000 LIMIT 10;"
        "TOP_10_STOCKS"  | "CURRENT_DEBT"               | "true"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE CURRENT_DEBT > 1000000 LIMIT 10;"
        "TOP_50_STOCKS"  | "TOTAL_CASH"                 | "TRUE"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE TOTAL_CASH > 1000000 LIMIT 50;"
        "TOP_100_STOCKS" | "TOTAL_DEBT"                 | "True"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE TOTAL_DEBT > 1000000 LIMIT 100;"
        "ALL_STOCKS"     | "SHARE_HOLDER_EQUITY"        | "false"   | "1,000,000"   || "SELECT * FROM financial_data WHERE SHARE_HOLDER_EQUITY < 1000000;"
        "TOP_10_STOCKS"  | "CASH_CHANGE"                | "False"   | "01,000,000"  || "SELECT * FROM financial_data WHERE CASH_CHANGE < 1000000 LIMIT 10;"
        "TOP_10_STOCKS"  | "CASH_FLOW"                  | "FALSE"   | "\$1000000"   || "SELECT * FROM financial_data WHERE CASH_FLOW < 1000000 LIMIT 10;"
        "TOP_10_STOCKS"  | "OPERATING_GAINS_LOSSES"     | "true"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE OPERATING_GAINS_LOSSES > 1000000 LIMIT 10;"
        "TOP_50_STOCKS"  | "MARKET_CAP"                 | "TRUE"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE MARKET_CAP > 1000000 LIMIT 50;"
        "TOP_100_STOCKS" | "DIVIDEND_RATE"              | "True"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE DIVIDEND_RATE > 1000000 LIMIT 100;"
        "ALL_STOCKS"     | "DIVIDEND_YIELD"             | "false"   | "1,000,000"   || "SELECT * FROM financial_data WHERE DIVIDEND_YIELD < 1000000;"
        "TOP_10_STOCKS"  | "CASH_TRAILING_TWELVE_MONTHS"| "False"   | "01,000,000"  || "SELECT * FROM financial_data WHERE CASH_TRAILING_TWELVE_MONTHS < 1000000 LIMIT 10;"
        "TOP_10_STOCKS"  | "DEBT_TRAILING_TWELVE_MONTHS"| "FALSE"   | "\$1000000"   || "SELECT * FROM financial_data WHERE DEBT_TRAILING_TWELVE_MONTHS < 1000000 LIMIT 10;"
        "TOP_10_STOCKS"  | "PROFIT_MARGIN"              | "False"   | "01,000,000"  || "SELECT * FROM financial_data WHERE PROFIT_MARGIN < 1000000 LIMIT 10;"
        "TOP_10_STOCKS"  | "PRICE_TO_SALES"             | "FALSE"   | "\$1000000"   || "SELECT * FROM financial_data WHERE PRICE_TO_SALES < 1000000 LIMIT 10;"
        "TOP_10_STOCKS"  | "PRICE_TO_BOOK"              | "true"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE PRICE_TO_BOOK > 1000000 LIMIT 10;"
        "TOP_50_STOCKS"  | "CURRENT_RATIO"              | "TRUE"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE CURRENT_RATIO > 1000000 LIMIT 50;"
        "TOP_100_STOCKS" | "CASH_RATIO"                 | "True"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE CASH_RATIO > 1000000 LIMIT 100;"
        "ALL_STOCKS"     | "OPERATING_CASH_FLOW_RATIO"  | "false"   | "1,000,000"   || "SELECT * FROM financial_data WHERE OPERATING_CASH_FLOW_RATIO < 1000000;"
        "TOP_10_STOCKS"  | "DEBT_RATIO"                 | "False"   | "01,000,000"  || "SELECT * FROM financial_data WHERE DEBT_RATIO < 1000000 LIMIT 10;"
        "TOP_10_STOCKS"  | "DEBT_TO_EQUITY_RATIO"       | "FALSE"   | "\$1000000"   || "SELECT * FROM financial_data WHERE DEBT_TO_EQUITY_RATIO < 1000000 LIMIT 10;"
        "TOP_10_STOCKS"  | "DEBT_SERVICE_COVERAGE_RATIO"| "true"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE DEBT_SERVICE_COVERAGE_RATIO > 1000000 LIMIT 10;"
        "TOP_50_STOCKS"  | "ASSET_TURNOVER_RATIO"       | "TRUE"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE ASSET_TURNOVER_RATIO > 1000000 LIMIT 50;"
        "TOP_100_STOCKS" | "GROSS_MARGIN_RATIO"         | "True"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE GROSS_MARGIN_RATIO > 1000000 LIMIT 100;"
        "ALL_STOCKS"     | "OPERATING_MARGIN_RATIO"     | "false"   | "1,000,000"   || "SELECT * FROM financial_data WHERE OPERATING_MARGIN_RATIO < 1000000;"
        "TOP_10_STOCKS"  | "RETURN_ON_ASSETS_RATIO"     | "False"   | "01,000,000"  || "SELECT * FROM financial_data WHERE RETURN_ON_ASSETS_RATIO < 1000000 LIMIT 10;"
        "TOP_10_STOCKS"  | "RETURN_ON_EQUITY_RATIO"     | "FALSE"   | "\$1000000"   || "SELECT * FROM financial_data WHERE RETURN_ON_EQUITY_RATIO < 1000000 LIMIT 10;"
        "TOP_10_STOCKS"  | "REVENUE_PER_SHARE_TRAILING_TWELVE_MONTHS"       | "true"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE REVENUE_PER_SHARE_TRAILING_TWELVE_MONTHS > 1000000 LIMIT 10;"
        "TOP_50_STOCKS"  | "REVENUE_PER_EMPLOYEE_TRAILING_TWELVE_MONTHS"    | "TRUE"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE REVENUE_PER_EMPLOYEE_TRAILING_TWELVE_MONTHS > 1000000 LIMIT 50;"
        "TOP_100_STOCKS" | "RETURN_ON_ASSETS_TRAILING_TWELVE_MONTHS"        | "True"    | "\$1,000,000" || "SELECT * FROM financial_data WHERE RETURN_ON_ASSETS_TRAILING_TWELVE_MONTHS > 1000000 LIMIT 100;"
        "ALL_STOCKS"     | "RETURN_ON_CAPITAL_TRAILING_TWELVE_MONTHS"       | "false"   | "1,000,000"   || "SELECT * FROM financial_data WHERE RETURN_ON_CAPITAL_TRAILING_TWELVE_MONTHS < 1000000;"



    }

    def 'buildRequestObject'(String find, String where, String isGreater, String amount) {
        RequestObject requestObject = new RequestObject()
        ConditionRequestObject conditionRequestObject = new ConditionRequestObject()

        conditionRequestObject.setWhere(where)
        conditionRequestObject.setIsGreater(isGreater)
        conditionRequestObject.setAmount(amount)

        requestObject.setConditionRequestObjects(conditionRequestObject)
        requestObject.setFind(find)

        return requestObject
    }

    def 'throwException'()
    {
        throw new IncorrectQuerySyntaxException("Syntax error");
    }

}
