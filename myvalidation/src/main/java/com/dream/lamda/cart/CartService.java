package com.dream.lamda.cart;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-12
 */
public class CartService {


    private static List<Sku> cartSkuList = new ArrayList<Sku>() {
        {
            add(new Sku(10001, "无人机", 1.21, 1, 1.21, Category.ELECTONICS));
        }

        {
            add(new Sku(10001, "手机", 1.27, 1, 1.27, Category.ELECTONICS));
        }

        {
            add(new Sku(10002, "牛仔裤", 1.22, 1, 1.22, Category.CLOTHING));
        }

        {
            add(new Sku(10003, "跑步机", 1.23, 1, 1.23, Category.SPRORTS));
        }

        {
            add(new Sku(10004, "JAVA编程", 1.24, 1, 1.24, Category.BOOKS));
        }

        {
            add(new Sku(10005, "算法", 1.25, 1, 1.25, Category.BOOKS));
        }

        {
            add(new Sku(10005, "WEB进阶指南", 1.26, 1, 1.26, Category.BOOKS));
        }
    };

    public static List<Sku> getCartSkuList() {
        return cartSkuList;
    }


    public static ArrayList<Sku> filter1(List<Sku> SkuList) {
        ArrayList<Sku> skus = new ArrayList<Sku>();
        for (Sku sku : SkuList) {
//            if (sku.getSkuCategory().equals(Category.ELECTONICS)) {
//                System.out.println(sku.getSkuName());
//                skus.add(sku);
//            }
            if (Category.ELECTONICS.equals(sku.getSkuCategory())) {
                skus.add(sku);
            }
        }

        return skus;
    }

    public static ArrayList<Sku> filter2(List<Sku> SkuList, Category category) {
        ArrayList<Sku> skus = new ArrayList<>();
        for (Sku sku : SkuList) {
//            if (sku.getSkuCategory().equals(Category.ELECTONICS)) {
//                System.out.println(sku.getSkuName());
//                skus.add(sku);
//            }
            if (category.equals(sku.getSkuCategory())) {
                skus.add(sku);
            }
        }

        return skus;
    }

    /**
     * 通过商品类型或者总价来过滤商品
     *
     * @param SkuList
     * @param category
     * @param totalPrice
     * @param categoryOrPrice
     * @return
     */
    public static ArrayList<Sku> filter3(List<Sku> SkuList, Category category, Double totalPrice, Boolean categoryOrPrice) {
        ArrayList<Sku> skus = new ArrayList<>();


        if (categoryOrPrice) {
            for (Sku sku : SkuList) {
                if (category.equals(sku.getSkuCategory())) {
                    skus.add(sku);
                }
            }
        } else {
            for (Sku sku : SkuList) {
                if (totalPrice.compareTo(sku.getTotalPrice()) == -1) {
                    skus.add(sku);
                }
            }
        }

        return skus;
    }

    /**
     *
     * 自己传入过滤方式
     *
     * @param SkuList
     * @param predicate
     * @return
     */
    public static ArrayList<Sku> filter4(List<Sku> SkuList, SkuPredicate predicate) {
        ArrayList<Sku> skus = new ArrayList<>();

        for (Sku sku : SkuList) {
            if (predicate.test(sku)) {
                skus.add(sku);
            }
        }

        return skus;
    }

    public static class Filter4Predicate implements SkuPredicate
    {
        @Override
        public boolean test(Sku sku) {
            boolean equals = Category.BOOKS.equals(sku.getSkuCategory());
            return equals;
        }
    }


}
