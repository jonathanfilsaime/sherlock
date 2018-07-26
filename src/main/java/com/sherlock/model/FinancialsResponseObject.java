package com.sherlock.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FinancialsResponseObject {

    private String symbol;
    private Financials[] Financials;

}
