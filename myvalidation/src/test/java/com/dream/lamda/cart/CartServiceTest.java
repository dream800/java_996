package com.dream.lamda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-12
 */
public class CartServiceTest {



    @Test
    public void filter1()
    {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        ArrayList<Sku> skus = CartService.filter1(cartSkuList);
        skus.forEach(e-> System.out.println(JSON.toJSONString(e, true)));
//
//
//        Sku sku = JSON.parseObject("{\"skuCategory\":\"ELECTONICS\",\"skuPrice\":1.21,\"totalNum\":1,\"totalPrice\":1.21,\"skuName\":\"无人机\"}", Sku.class);
////        Sku sku = JSON.parseObject("{\"skuPrice\":1.21,\"totalNum\":1,\"totalPrice\":1.21,\"skuName\":\"无人机\"}", Sku.class);
//
//        System.out.println(sku.getSkuName());
//        System.out.println(sku.getSkuCategory());

//        HashMap<String, Object> map = new HashMap<>();
//        map.put("code", 200);
//        map.put("data", Arrays.asList(1,2,3,3,4,5));
//        map.put("message", "success");
//        Object o = JSON.toJSON(map);
//        System.out.println(((Map) o).get("code"));

//        System.out.println(JSON.toJSON(map));

    }


    @Test
    public void filter2()
    {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        ArrayList<Sku> skus = CartService.filter2(cartSkuList, Category.BOOKS);
        skus.forEach(e-> System.out.println(JSON.toJSONString(e, true)));
    }


    @Test
    public void filter3()
    {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        ArrayList<Sku> skus = CartService.filter3(cartSkuList, null, 1.21, false);
        skus.forEach(e-> System.out.println(JSON.toJSONString(e, true)));
    }




    @Test
    public void filter4()
    {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        ArrayList<Sku> skus = CartService.filter4(cartSkuList, new CartService.Filter4Predicate());
        skus.forEach(e-> System.out.println(JSON.toJSONString(e, true)));
    }



    @Test
    public void filter5()
    {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        ArrayList<Sku> skus = CartService.filter4(cartSkuList, sku-> Category.BOOKS.equals(sku.getSkuCategory())) ;
        skus.forEach(e-> System.out.println(JSON.toJSONString(e, true)));
    }

}
