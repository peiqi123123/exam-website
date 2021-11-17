package com.whpu.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/17 8:42
 */
@Data
@TableName("tfQuestion")
public class TFQuestion {
    private String questionId;
    private String questionContent;
    private Integer answer;
    private String analyse;
}
