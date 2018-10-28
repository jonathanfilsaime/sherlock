package com.sherlock.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class RequestObject {
    private String find;
    private ConditionRequestObject[] conditionRequestObjects;

}
