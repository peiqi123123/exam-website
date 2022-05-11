package com.whpu.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Hoodie
 * @since 2022/5/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("返回所有教师ID")
public class TeacherIdsVo implements Serializable {
    @ApiModelProperty("教师id列表")
    private List<String> teacherIds;
}
