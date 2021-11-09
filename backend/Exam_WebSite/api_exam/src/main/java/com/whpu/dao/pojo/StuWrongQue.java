package com.whpu.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/11/8 15:50
 */
@Data
public class StuWrongQue {
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    private String studentId;
    private String questionId;
    private String recordingId;
    private String studentAns;
}
