package com.dream.basic;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-10
 */
public class ThreadTest {

    public static void main(String[] args) {

//        new MyThread().start();

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("current thread: " + Thread.currentThread().getName());
            }
        };
        thread.start();

        System.out.println("main thread");

    }

}

class MyThread extends Thread{
    @Override
    public void run() {

        System.out.println("current thread: " + Thread.currentThread().getName());

    }
}
