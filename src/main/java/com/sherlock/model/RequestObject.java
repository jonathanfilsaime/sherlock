package com.sherlock.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@ApiModel
public class RequestObject {

    @Valid
    @NotNull
    @ApiModelProperty(required = true, value = "The max number of results requested")
    private String find;

    @Valid
    @NotNull
    @ApiModelProperty(required = true, value = "The search query conditions")
    private ConditionRequestObject[] conditionRequestObjects;

}
