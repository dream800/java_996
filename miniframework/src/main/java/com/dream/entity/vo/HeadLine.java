package com.dream.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-25
 */

@Data
public class HeadLine {


    private Long lineId;

    private String lineName;

    private String lineLink;

    private String lineImg;

    private Integer priority;

    private Integer enableStatus;

    private Date createTime;

    private Date lastEditTime;



}
