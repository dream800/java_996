package com.dream.lamda.stream;

import com.alibaba.fastjson.JSON;
import com.dream.lamda.cart.CartService;
import com.dream.lamda.cart.Category;
import com.dream.lamda.cart.Sku;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-07-03
 */
public class StreamOperator {


    List<Sku> list;

    @Before
    public void init()
    {
        list = CartService.getCartSkuList();
    }

    @Test
    public void filter1()
    {
        list.stream().filter(sku -> Category.BOOKS.equals(sku.getSkuCategory()))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));

    }

    @Test
    public void filter2()
    {
        list.stream().map(sku -> sku.getSkuName())
                .forEach(System.out::println);

    }

    @Test
    public void filter3()
    {
        list.stream()
                .map(sku -> sku.getSkuName().split(""))
//                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(System.out::println);
    }


    @Test
    public void filter4()
    {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .map(sku -> sku.getTotalPrice())
                .forEach(System.out::println);
    }


    @Test
    public void filter5()
    {
        list.stream()
                .map(sku -> sku.getSkuCategory())
                .distinct()
                .forEach(item -> {
                    System.out.println(item);
                });
    }


    @Test
    public void filter6()
    {
        boolean b = list.stream()
                .allMatch(sku -> sku.getTotalPrice() > 1.23);
        System.out.println(b);
    }

    @Test
    public void filter7()
    {
//        boolean b = list.stream()
//                .anyMatch(sku -> sku.getTotalPrice() > 1.27);
//        System.out.println(b);

        boolean b2 = list.stream()
                .noneMatch(sku -> sku.getTotalPrice() > 1.23);
        System.out.println(b2);
    }


    @Test
    public void filter8()
    {
//        list.stream()
//                .forEach(sku -> System.out.println(sku.getSkuName()));

        Optional<Sku> first = list.stream()
                .findFirst();

        System.out.println(first.get().getSkuName());

        Optional<Sku> any = list.stream()
                .findAny();
        System.out.println(any.get().getSkuName());
        
    }


    @Test
    public void filter9()
    {
        OptionalDouble max1 = list.stream()
                .mapToDouble(Sku::getTotalPrice)
                .max();
         System.out.println(max1.getAsDouble());

        System.out.println(list.stream().count());

    }

    @Test
    public void filter10() throws IOException {
//        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
//        integerStream.forEach(integer -> System.out.println(integer));
//
//        int[] arr = {1,2,3,4,5};
//        Arrays.stream(arr).forEach(e-> System.out.println(e));
//
//
//        Stream<String> lines = Files.lines(Paths.get("D:\\code\\java2022\\java_996\\myvalidation\\src\\test\\java\\com\\dream\\lamda\\stream\\StreamOperator.java"));
//        lines.forEach(e-> System.out.println(e));


//        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);
//        iterate.forEach(e-> System.out.println(e));

        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(100).forEach(e-> System.out.println(e));


    }


    @Test
    public void filter11()
    {
//        System.out.println(list.stream()
//                .filter(sku -> sku.getTotalPrice() > 1.26)
//                .map(sku -> sku.getTotalPrice())
//                .collect(Collectors.toList()));

//        System.out.println(list.stream()
//                .filter(sku -> sku.getTotalPrice() > 1.26)
//                .map(sku -> sku.getTotalPrice())
//                .collect(Collectors.toMap()));

//        Map<Enum, List<Sku>> collect = list.stream()
//                .collect(Collectors.groupingBy(sku -> sku.getSkuCategory()));


        Map<Boolean, List<Sku>> collect = list.stream()
                .collect(Collectors.partitioningBy(sku -> sku.getTotalPrice() > 1.25));


        System.out.println(JSON.toJSONString(collect,true));
    }


    @Test
    public void filter12()
    {







    }


    @Test
    public void filter13()
    {

    }

    @Test
    public void filter14()
    {

    }

    @Test
    public void filter15()
    {

    }

}
