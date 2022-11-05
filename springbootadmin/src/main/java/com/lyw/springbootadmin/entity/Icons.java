package com.lyw.springbootadmin.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author lyw
 * @since 2022-11-04
 */
@Getter
@Setter
@ApiModel(value = "Icons对象", description = "")
@ToString
public class Icons implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("图标名称")
    private String username;

    @ApiModelProperty("图标值")
    private String iconValue;

    @ApiModelProperty("图标类型")
    private String iconType;


}
