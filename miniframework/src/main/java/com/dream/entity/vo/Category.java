package com.dream.entity.vo;

import lombok.Data;

import java.net.ServerSocket;
import java.util.Date;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-25
 */

@Data
public class Category {


    private Long id;

    private String name;

    private String desc;

    private String img;

    private Integer priority;


    private Date createTime;

    private Date lastEditTime;



}
