package com.whpu.vo.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
@Data
@ApiModel("专题组卷时的参数")
public class TopicParam {
    @ApiModelProperty("知识点数组")
    private ArrayList<Integer> topics;
    @ApiModelProperty("题目数量")
    private Integer questionNum;
}
