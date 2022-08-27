package com.dream.lamda.stream;

import com.alibaba.fastjson.JSON;
import com.dream.lamda.cart.CartService;
import com.dream.lamda.cart.Category;
import com.dream.lamda.cart.Sku;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-07-02
 */
public class StreamVS {

    @Test
    public void filter1()
    {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        cartSkuList.forEach(item->{
            System.out.println(item.getSkuName());
        });

        ArrayList<Sku> skus = new ArrayList<>();
        ArrayList<Sku> skusElse = new ArrayList<>();

        cartSkuList.forEach(item->{
            if (item.getSkuCategory().equals(Category.BOOKS)) {
                skus.add(item);
            } else {
                skusElse.add(item);
            }
        });

        for (int j = 0; j < skusElse.size(); j++) {
            for (int i = j; i < skusElse.size() - 1; i++) {
                if (skusElse.get(i).getTotalPrice().compareTo(skusElse.get(i + 1).getTotalPrice()) > 0) {
                    Sku temp = skusElse.get(i);
                    skusElse.set(i, skusElse.get(i+1));
                    skusElse.set(i+1, temp);
                }
            }
        }

        skusElse.forEach(item-> System.out.println(item.getTotalPrice()));



    }


    @Test
    public void filter2()
    {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));

//        cartSkuList.forEach(sku -> System.out.println(sku.getSkuName()));

        cartSkuList.stream()
//                .peek(sku -> System.out.println(sku.getSkuName()))
                .filter(sku -> Category.BOOKS.equals(sku.getSkuCategory()))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));

        List<Double> collect = cartSkuList.stream()
                .filter(sku -> !Category.BOOKS.equals(sku.getSkuCategory()))
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                .limit(2)
                .peek(sku -> money.set(money.get() + sku.getTotalPrice()))
                .map(sku -> sku.getTotalPrice())
                .collect(Collectors.toList());

        System.out.println(collect);


    }



}
