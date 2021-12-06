package com.whpu.vo.params;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/8 15:10
 */
@Data
public class SubmitParam {
    private List<AnsParam> questionAnswers;
    private Integer totalTime;
    private String examId;
}
