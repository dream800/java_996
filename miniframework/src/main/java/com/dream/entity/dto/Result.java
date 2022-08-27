package com.dream.entity.dto;

import lombok.Data;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-25
 */
@Data
public class Result<T> {

    private int code;

    private String msg;

    private T data;

}
