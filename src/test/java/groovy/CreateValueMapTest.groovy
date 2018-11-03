package groovy

import com.sherlock.computation.QueryParser
import com.sherlock.validation.Validation
import spock.lang.Shared
import spock.lang.Specification

class CreateValueMapTest extends Specification{

    @Shared
    QueryParser queryParser = new QueryParser();

    def'createMapTest'()
    {
        expect:
        Validation.validateWhereCondition(queryParser.createValueMap(sql.split("\\s+"))) == expectedResult

        where:
        sql                                                                                                                 || expectedResult
        "Find:TOP_10_STOCKS Where:GROSS_PROFIT is:greater Than:\$1,000,000"                                                 || true
        "Find:TOP_50_STOCKS Where:GROSS_PROFIT is:less Than:\$1,000,000 Where:NET_INCOME is:greater Than:\$2,000,000"       || true
        "Find:TOP_100_STOCKS Where:GROSS_PROFIT is:greater Than:\$1,000,000"                                                || true
        "Find:TOP_50_STOCKS Where:GROSS_PROFIT is:less Than:\$1,000,000"                                                    || true
        "Find:TOP_10_STOCKS Where:GROSS_PROFIT is:greater Than:1,000,000"                                                   || true
        "Find:TOP_100_STOCKS Where:GROSS_PROFIT is:less Than:01,000,000"                                                    || true
        "Find:TOP_50_STOCKS Where:GROSS_PROFIT is:greater Than:\$1,000,000"                                                 || true
        "Find:TOP_10_STOCKS Where:GROSS_PROFIT is:less Than:\$1,000,000"                                                    || true
        "Find:TOP_10_STOCKS Where:GROSS_PROFIT is:greater Than:\$1,000,000"                                                 || true
        "Find:TOP_100_STOCKS Where:GROSS_PROFIT is:less Than:\$1,000,000"                                                   || true
        "Find:TOP_50_STOCKS Where:GROSS_PROFIT is:true Than:\$1,000,000"                                                    || true
        "Find:TOP_10_STOCKS Where:GROSS_PROFIT is:True Than:\$1,000,000"                                                    || true
        "Find:TOP_10_STOCKS Where:GROSS_PROFIT is:TRUE Than:\$1,000,000"                                                    || true
        "Find:TOP_50_STOCKS Where:GROSS_PROFIT is:false Than:\$1,000,000"                                                   || true
        "Find:TOP_10_STOCKS Where:GROSS_PROFIT is:fAlse Than:\$1,000,000"                                                   || true
        "Find:TOP_10_STOCKS Where:GROSS_PROFIT is:FALSE Than:\$1,000,000"                                                   || true
        "Find:TOP_1_STOCKS Where:GROSS_PROFIT is:greater Than:\$1,000,000"                                                  || false
        "Find:TOP_50_STOCKS Where:GRSS_PROFIT is:less Than:\$1,000,000 Where:NET_INCOME is:greater Than:\$2,000,000"        || false
        "Find:TOP_100_STOCKS Where:GROSS_PROFIT is:grater Than:\$1,000,000"                                                 || false
        "Find:TOP_50_STOCKS Where:GROSS_PROFIT is:les Than:\$1,000,000"                                                     || false
        "Find:TOP_10_STOCKS Where:GROSS_PROFIT is:tru Than:1,000,000"                                                       || false
        "Find:TOP_100_STOCKS Where:PROFIT is:less Than:01,000,000"                                                          || false
        "Find:TOP_50_STOCKS Where:GROSS_PROFIT is:greater Than:hi"                                                          || false
        "Find:TOP_50_STOCKS Where:GROSS_PROFIT is:less Than:\$1,000,000 Where:NET_INCOME is:greater Than:\$2,000,000 Where:MARKET_CAP is:less Than:\$500,000 Where:CURRENT_CASH is:less Than:\$30,000"    || true





    }
}
