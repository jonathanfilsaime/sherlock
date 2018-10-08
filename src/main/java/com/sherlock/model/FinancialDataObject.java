package com.sherlock.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FinancialDataObject {

    private String symbol;
    private Financials[] Financials;

}
