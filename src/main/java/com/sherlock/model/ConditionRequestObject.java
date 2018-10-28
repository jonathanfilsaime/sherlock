package com.sherlock.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConditionRequestObject {
    private String where;
    private String isGreater;
    private String amount;
}
