package com.dream.basic;

/**
 * 描述信息
 *
 * @author dream
 * @create 2022-06-10
 */
public class RunableTest {

    public static void main(String[] args) {


        //new Thread(new RunabledTest()).start();

        new Thread(new Runnable() {
            @Override
            public void run() {


                System.out.println("current thread: " + Thread.currentThread().getName());
            }
        }).start();




        System.out.println("main thread");

    }

}


class RunabledTest implements Runnable
{
    @Override
    public void run() {
        System.out.println("current thread: " + Thread.currentThread().getName());
    }
}
