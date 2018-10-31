package com.sherlock.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ConditionRequestObject {

    @Valid
    @NotNull
    @ApiModelProperty( required = true, value = "The attribute of interest")
    private String where;

    @Valid
    @NotNull
    @ApiModelProperty( required = true, value = "The operator can be true or false")
    private String isGreater;

    @Valid
    @NotNull
    @ApiModelProperty( required = true, value = "The dollar amount")
    private String amount;
}
