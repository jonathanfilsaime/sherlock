package com.sherlock.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@Data
@ApiIgnore
@NoArgsConstructor
public class SymbolObjectResponse {

    private String symbol;
    private String name;
    private String date;
    private boolean isEnabled;
    private String type;
    private String iexId;
}
