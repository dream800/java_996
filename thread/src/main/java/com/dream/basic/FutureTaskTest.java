package com.dream.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-10
 */
public class FutureTaskTest {

    public static void main(String[] args) {

        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();

        FutureTask<String> future1 = new FutureTask<String>(task1);
        FutureTask<String> future2 = new FutureTask<String>(task2);
        FutureTask<String> future3 = new FutureTask<String>(task3);

        new Thread(future1).start();
        new Thread(future2).start();
        new Thread(future3).start();


//        Thread thread = new Thread(new FutureTask<String>(() -> {
//
//            return "haha";
//        }));


        while (true) {
            if (future1.isDone() && future2.isDone() && future3.isDone()) {
                System.out.println("all finish...");
                break;
            }
        }

        try {
            String s1 = future1.get();
            System.out.println(s1);
            String s2 = future2.get();
            System.out.println(s2);
            String s3 = future3.get();
            System.out.println(s3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        System.out.println("main thread");
    }


}


class Task1 implements Callable
{
    @Override
    public String  call() throws Exception {

        TimeUnit.SECONDS.sleep(1);
        System.out.println("current thread: " + Thread.currentThread().getName());

        return "hello1";
    }
}

class Task2 implements Callable
{
    @Override
    public String  call() throws Exception {

        TimeUnit.SECONDS.sleep(1);
        System.out.println("current thread: " + Thread.currentThread().getName());

        return "hello2";
    }
}

class Task3 implements Callable
{
    @Override
    public String  call() throws Exception {

        TimeUnit.SECONDS.sleep(1);
        System.out.println("current thread: " + Thread.currentThread().getName());

        return "hello3";
    }
}