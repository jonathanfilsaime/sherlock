package com.sherlock.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@ApiModel
public class RequestObject {

    @ApiModelProperty(required = true, value = "The max number of results requested")
    private String find;

    @ApiModelProperty(required = true, value = "The search query conditions")
    private ConditionRequestObject[] conditionRequestObjects;

}
