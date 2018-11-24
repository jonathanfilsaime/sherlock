## Purpose

The purpose of this project is to allow the user to have a access to a searchable database of all currently listed 
securities. 

## Where the data comes from 

The data is collected from the iex API. https://iextrading.com/developer/docs/ and organized into searchable rows.

## Attribution 

“Data provided for free by IEX. View IEX’s Terms of Use.”

## Documentation (Swagger doc)

https://sherlock-220614.appspot.com/swagger-ui.html#/

- POST 

    RequestObject
    {
        find*	string
            [
                ConditionRequestObject
                    {
                        amount*	string
                        isGreater*	string
                        where*	string
                    }
            ]
    }
    
- Response 

    ResponseObject
    {
        asset_TURNOVER_RATIO	number
        cash_CHANGE	number
        cash_FLOW	number
        cash_RATIO	number
        cash_TRAILING_TWELVE_MONTHS	number
        company_NAME	string
        cost_OF_REVENUE	number
        current_ASSETS	number
        current_CASH	number
        current_DEBT	number
        current_RATIO	number
        debt_RATIO	number
        debt_SERVICE_COVERAGE_RATIO	number
        debt_TO_EQUITY_RATIO	number
        debt_TRAILING_TWELVE_MONTHS	number
        dividend_RATE	number
        dividend_YIELD	number
        gross_MARGIN_RATIO	number
        gross_PROFIT	number
        id	integer($int64)
        market_CAP	number
        net_INCOME	number
        operating_CASH_FLOW_RATIO	number
        operating_EXPENSES	number
        operating_GAINS_LOSSES	number
        operating_INCOME	number
        operating_MARGIN_RATIO	number
        operating_REVENUE	number
        price_TO_BOOK	number
        price_TO_SALES	number
        profit_MARGIN	number
        report_DATE	string
        research_AND_DEVELOPMENT	number
        return_ON_ASSETS_RATIO	number
        return_ON_ASSETS_TRAILING_TWELVE_MONTHS	number
        return_ON_CAPITAL_TRAILING_TWELVE_MONTHS	number
        return_ON_EQUITY_RATIO	number
        revenue_PER_EMPLOYEE_TRAILING_TWELVE_MONTHS	number
        revenue_PER_SHARE_TRAILING_TWELVE_MONTHS	number
        share_HOLDER_EQUITY	number
        ticker_SYMBOL	string
        total_ASSETS	number
        total_CASH	number
        total_DEBT	number
        total_LIABILITIES	number
        total_REVENUE	number
    }

## DataBase schema 

- REPORT_DATE varchar(255) not null
- COMPANY_NAME varchar(255) not null
- TICKER_SYMBOL varchar(255) not null
- GROSS_PROFIT DECIMAL(30,10)
- COST_OF_REVENUE DECIMAL(30,10)
- OPERATING_REVENUE DECIMAL(30,10)
- TOTAL_REVENUE DECIMAL(30,10)
- OPERATING_INCOME DECIMAL(30,10)
- NET_INCOME DECIMAL(30,10)
- RESEARCH_AND_DEVELOPMENT DECIMAL(30,10)
- OPERATING_EXPENSES DECIMAL(30,10)
- CURRENT_ASSETS DECIMAL(30,10)
- TOTAL_ASSETS DECIMAL(30,10)
- TOTAL_LIABILITIES DECIMAL(30,10)
- CURRENT_CASH DECIMAL(30,10)
- CURRENT_DEBT DECIMAL(30,10)
- TOTAL_CASH DECIMAL(30,10)
- TOTAL_DEBT DECIMAL(30,10)
- SHARE_HOLDER_EQUITY DECIMAL(30,10)
- CASH_CHANGE DECIMAL(30,10)
- CASH_FLOW DECIMAL(30,10)
- OPERATING_GAINS_LOSSES DECIMAL(30,10)
- MARKET_CAP DECIMAL(30,10)
- DIVIDEND_RATE DECIMAL(30,10)
- DIVIDEND_YIELD DECIMAL(30,10)
- CASH_TRAILING_TWELVE_MONTHS DECIMAL(30,10)
- DEBT_TRAILING_TWELVE_MONTHS DECIMAL(30,10)
- REVENUE_PER_SHARE_TRAILING_TWELVE_MONTHS DECIMAL(30,10)
- REVENUE_PER_EMPLOYEE_TRAILING_TWELVE_MONTHS DECIMAL(30,10)
- RETURN_ON_ASSETS_TRAILING_TWELVE_MONTHS DECIMAL(30,10)
- RETURN_ON_CAPITAL_TRAILING_TWELVE_MONTHS DECIMAL(30,10)
- PROFIT_MARGIN DECIMAL(30,10)
- PRICE_TO_SALES DECIMAL(30,10)
- PRICE_TO_BOOK DECIMAL(30,10)
- CURRENT_RATIO DECIMAL(30,10)
- CASH_RATIO DECIMAL(30,10)
- OPERATING_CASH_FLOW_RATIO DECIMAL(30,10)
- DEBT_RATIO DECIMAL(30,10)
- DEBT_TO_EQUITY_RATIO DECIMAL(30,10)
- DEBT_SERVICE_COVERAGE_RATIO DECIMAL(30,10)
- ASSET_TURNOVER_RATIO DECIMAL(30,10)
- GROSS_MARGIN_RATIO DECIMAL(30,10)
- OPERATING_MARGIN_RATIO DECIMAL(30,10)
- RETURN_ON_ASSETS_RATIO DECIMAL(30,10)
- RETURN_ON_EQUITY_RATIO DECIMAL(30,10)