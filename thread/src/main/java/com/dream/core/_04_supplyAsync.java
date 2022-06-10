package com.dream.core;

import java.text.MessageFormat;
import java.util.concurrent.CompletableFuture;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-10
 */
public class _04_supplyAsync {

    public static void main(String[] args) {

        SmallTool.printTimeAndThread("小白进入餐厅");
        SmallTool.printTimeAndThread("小白点了 番 茄炒蛋 + 一碗米饭");


        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {

            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMillis(200);

            return "番茄炒蛋";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            SmallTool.printTimeAndThread("服务员蒸饭");
            SmallTool.sleepMillis(100);

            return "米饭";
        }), (dish, race)  -> {
            SmallTool.sleepMillis(100);
            SmallTool.printTimeAndThread("服务员打饭");

//            return MessageFormat.format("{} + {} 好了", dish, race);
            return String.format("%s + %s 好了", dish, race);
        });




//        Thread thread = new Thread(new FutureTask<String>(() -> {
//            return "haha";
//        }));


        SmallTool.printTimeAndThread("小白在打王者");
        SmallTool.printTimeAndThread(String.format("%s, 小白开吃", cf1.join()));




    }

}
