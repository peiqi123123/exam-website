package com.whpu.vo.params;

import lombok.Data;

import java.util.ArrayList;
@Data
public class TopicParam {
    private ArrayList<Integer> topics;
    private Integer questionNum;
}
