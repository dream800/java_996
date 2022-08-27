package com.dream.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-25
 */
@Data
public class MainPageInfoVO {


    private List<HeadLine> headLines;

    private List<Category> categories;

}
