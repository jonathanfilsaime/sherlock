package com.sherlock.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@Data
@NoArgsConstructor
public class ConditionRequestObject {

    @ApiModelProperty( required = true, value = "The attribute of interest")
    private String where;

    @ApiModelProperty( required = true, value = "The operator can be true or false")
    private String isGreater;

    @ApiModelProperty( required = true, value = "The dollar amount")
    private String amount;
}
