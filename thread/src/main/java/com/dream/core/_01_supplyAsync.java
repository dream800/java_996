package com.dream.core;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-10
 */
public class _01_supplyAsync {

    public static void main(String[] args) {

        SmallTool.printTimeAndThread("小白进入餐厅");
        SmallTool.printTimeAndThread("小白点了 番 茄炒蛋 + 一碗米饭");


        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {

            SmallTool.printTimeAndThread("厨师炒菜");
            SmallTool.sleepMillis(200);

            SmallTool.printTimeAndThread("厨师打饭");
            SmallTool.sleepMillis(100);


            return "番茄炒蛋  + 米饭好了";
        });


//        Thread thread = new Thread(new FutureTask<String>(() -> {
//            return "haha";
//        }));


        SmallTool.printTimeAndThread("小白在打王者");
        SmallTool.printTimeAndThread(String.format("%s, 小白开吃", cf1.join()));




    }

}
