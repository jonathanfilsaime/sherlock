package com.sherlock.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@Data
@ApiIgnore
@NoArgsConstructor
public class FinancialDataObject {

    private String symbol;
    private Financials[] Financials;

}
