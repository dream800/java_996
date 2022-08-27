package com.dream.lamda.cart;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-12
 */
public class Sku {


//    @JSONField(name = "json之后的名字", ordinal = 2, serialize = false)
    private Integer skuId;

    @JSONField(ordinal = 1)
    private String skuName;

    private Double skuPrice;

    private Integer totalNum;

    private Double totalPrice;

    @JSONField(deserialize = false, serialize = false)
    private Category skuCategory;


    public Sku(Integer skuId, String skuName, Double skuPrice, Integer totalNum, Double totalPrice, Category skuCategory) {
        this.skuId = skuId;
        this.skuName = skuName;
        this.skuPrice = skuPrice;
        this.totalNum = totalNum;
        this.totalPrice = totalPrice;
        this.skuCategory = skuCategory;
    }

//
//    @Override
//    public String toString() {
//        return "Sku{" +
//                "skuId=" + skuId +
//                ", skuName='" + skuName + '\'' +
//                ", skuPrice=" + skuPrice +
//                ", totalNum=" + totalNum +
//                ", totalPrice=" + totalPrice +
//                ", skuCategory=" + skuCategory +
//                '}';
//    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Double getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(Double skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Enum getSkuCategory() {
        return skuCategory;
    }

    public void setSkuCategory(Category skuCategory) {
        this.skuCategory = skuCategory;
    }
}
