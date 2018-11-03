package groovy

import com.sherlock.computation.QueryParser
import com.sherlock.model.ConditionRequestObject
import com.sherlock.model.RequestObject
import com.sherlock.validation.Validation
import spock.lang.Shared
import spock.lang.Specification

class CreateValueMapFromRequestObjectTest extends Specification{

    @Shared
    QueryParser queryParser = new QueryParser()


    def'createMapTest'()
    {
        expect:
        Validation.validateWhereCondition(queryParser.createValueMapFromRequestObject(buildRequestObject(find, where, isGreater, amount))) == expectedResult

        where:
        find             | where                        | isGreater | amount        || expectedResult
        "TOP_10_STOCKS"  | "GROSS_PROFIT"               | "true"    | "\$1,000,000" || true
        "TOP_50_STOCKS"  | "COST_OF_REVENUE"            | "TRUE"    | "\$1,000,000" || true
        "TOP_100_STOCKS" | "OPERATING_REVENUE"          | "True"    | "\$1,000,000" || true
        "ALL_STOCKS"     | "NET_INCOME"                 | "false"   | "1,000,000"   || true
        "TOP_10_STOCKS"  | "RESEARCH_AND_DEVELOPMENT"   | "False"   | "01,000,000"  || true
        "TOP_10_STOCKS"  | "OPERATING_EXPENSES"         | "FALSE"   | "\$1000000"   || true
        "TOP_10_STOCKS"  | "CURRENT_ASSETS"             | "true"    | "\$1,000,000" || true
        "TOP_50_STOCKS"  | "TOTAL_ASSETS"               | "TRUE"    | "\$1,000,000" || true
        "TOP_100_STOCKS" | "DIVIDEND_RATE"              | "True"    | "\$1,000,000" || true
        "ALL_STOCKS"     | "CURRENT_RATIO"              | "false"   | "1,000,000"   || true
        "TOP_10_STOCKS"  | "TOTAL_LIABILITIES"          | "False"   | "01,000,000"  || true
        "TOP_10_STOCKS"  | "CURRENT_CASH"               | "FALSE"   | "\$1000000"   || true
        "TOP_10_STOCKS"  | "CURRENT_DEBT"               | "true"    | "\$1,000,000" || true
        "TOP_50_STOCKS"  | "TOTAL_CASH"                 | "TRUE"    | "\$1,000,000" || true
        "TOP_100_STOCKS" | "TOTAL_DEBT"                 | "True"    | "\$1,000,000" || true
        "ALL_STOCKS"     | "SHARE_HOLDER_EQUITY"        | "false"   | "1,000,000"   || true
        "TOP_10_STOCKS"  | "CASH_CHANGE"                | "False"   | "01,000,000"  || true
        "TOP_10_STOCKS"  | "CASH_FLOW"                  | "FALSE"   | "\$1000000"   || true
        "TOP_20_STOCKS"  | "CURRENT_CASH"               | "FALSE"   | "\$1000000"   || false
        "TOP_10_STOCKS"  | "CURREN_DEBT"                | "true"    | "\$1,000,000" || false
        "TOP_50_STOCKS"  | "TOTAL_CASH"                 | "TRUEe"   | "\$1,000,000" || false
        "ALL_STOCK"      | "SHARE_HOLDER_EQUITY"        | "false"   | "1,000,000"   || false
        "TOP_10_STOCKS"  | "CASH_CHANGE"                | "Flase"   | "01,000,000"  || false
        "TOP_10_STOCKS"  | "CASH_FLOW,"                 | "FALSE"   | "\$1000000"   || false

    }

    def 'buildRequestObject'(find, where, isGreater, amount)
    {
        ConditionRequestObject conditionRequestObject = new ConditionRequestObject()
        RequestObject requestObject = new RequestObject()

        requestObject.setFind(find)
        conditionRequestObject.setWhere(where)
        conditionRequestObject.setIsGreater(isGreater)
        conditionRequestObject.setAmount(amount)
        requestObject.setConditionRequestObjects(conditionRequestObject)

        return requestObject
    }


}
