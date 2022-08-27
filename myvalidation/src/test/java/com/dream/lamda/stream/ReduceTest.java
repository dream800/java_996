package com.dream.lamda.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-07-09
 */
public class ReduceTest {


    @Test
    public void before()
    {
        @Data
        @AllArgsConstructor
        class Order
        {
            private Integer id;
            private Integer count;
            private Double totalAmount;
        }

        ArrayList<Order> list = new ArrayList<Order>();
        list.add(new Order(1, 2, 25.12));
        list.add(new Order(2, 5, 257.23));
        list.add(new Order(3, 5, 257.23));


        Order reduce = list.stream()
                .parallel()
                .reduce(new Order(0, 0, 0.0),
                        (Order order1, Order order2) -> {
                            Integer count = order1.getCount() + order2.getCount();
                            Double d = order1.getTotalAmount() + order2.getTotalAmount();
                            return new Order(0, count, d);
                        }, (Order order1, Order order2) -> {
                            Integer count = order1.getCount() + order2.getCount();
                            Double d = order1.getTotalAmount() + order2.getTotalAmount();
                            return new Order(0, count, d);
                        }

                );

        System.out.println(reduce.getCount());
        System.out.println(reduce.getTotalAmount());

    }



    @Test
    public void test1()
    {
        @Data
        @AllArgsConstructor
        class Student
        {
            private String name;
            private Integer score;
            private String subject;
        }

        Map<String , List<Student>> map = new HashMap<>();

        ArrayList<Student> list1 = new ArrayList<>();
        list1.add(new Student("zhangsan", 10, "语文"));
        list1.add(new Student("zhangsan", 11, "数学"));
        list1.add(new Student("zhangsan", 12, "英语"));
        map.put("zhangsan", list1);


        ArrayList<Student> list2 = new ArrayList<>();
        list2.add(new Student("lisi", 10, "语文"));
        list2.add(new Student("lisi", 11, "数学"));
        list2.add(new Student("lisi", 12, "英语"));
        map.put("lisi", list2);


        ArrayList<Student> list3 = new ArrayList<>();
        list3.add(new Student("wangwu", 10, "语文"));
        list3.add(new Student("wangwu", null, "数学"));
        list3.add(new Student("wangwu", 12, "英语"));
        map.put("wangwu", list3);

        map.forEach((K, V) -> {
//            V.stream().filter(student -> Objects.isNull(student.getScore()))
//                    .forEach(student -> System.out.println(student.getName() + student.getSubject()));
            boolean b = V.stream().anyMatch(student -> student.getScore() == null);
            if (b) {
                System.out.println(K);
            }
        });

    }



    @Test
    public void test2()
    {
        @Data
        @AllArgsConstructor
        class Tag
        {
            private String name;
            private Integer age;
        }

//        List<String> tagListFromDB;
//        List<Tag> tagReq;

        List<String> tagListFromDB = Arrays.asList("李四", "王五", "赵柳");
        List<Tag> tagReq = new ArrayList<>();

        tagReq.add(new Tag("张三", 20));
        tagReq.add(new Tag("李四", 30));
        tagReq.add(new Tag("张三", 10));



        tagReq.stream()
                .filter(tag -> !tagListFromDB.contains(tag.getName()))
                .distinct()
                .forEach(tag -> System.out.println(tag));

    }
}
