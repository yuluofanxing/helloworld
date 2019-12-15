package com.aotuo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private boolean flag; //是否成功
    private Integer code; //返回码
    private String message; //返回信息
    private Object data; //返回数据
}
