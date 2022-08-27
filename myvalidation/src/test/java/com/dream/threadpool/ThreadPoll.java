package com.dream.threadpool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-07-17
 */
public class ThreadPoll {


    @Test
    public void oldHandle() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{

                System.out.println("start to handle current doc...");

                try {
                    Thread.sleep(1000L * 30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("finish current doc....");
            }).start();
        }

        Thread.sleep(1000L * 1000);
    }

    @Test
    public void oldHandle1() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executor.submit(()-> {

                System.out.println("start to handle current doc...");

                try {
                    Thread.sleep(1000L * 30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("finish current doc....");
            });
        }

        Thread.sleep(1000L * 1000);
    }


    @Test
    public void queueA() throws InterruptedException {
        ArrayBlockingQueue<Integer> integers = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 20; i++) {
            integers.put(i);
            System.out.println("添加： " + i);
        }
    }

    @Test
    public void queueB() throws InterruptedException {
        LinkedBlockingQueue<Integer> integers = new LinkedBlockingQueue<>(10);
        for (int i = 0; i < 20; i++) {
            integers.put(i);
            System.out.println("添加： " + i);
        }


//        Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool();
//        Executors.newSingleThreadExecutor();
//        Executors.newCachedThreadPool().submit()

    }



}
