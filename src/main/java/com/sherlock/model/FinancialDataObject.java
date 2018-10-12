package com.sherlock.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class FinancialDataObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String symbol;
    private Financials[] Financials;

}
