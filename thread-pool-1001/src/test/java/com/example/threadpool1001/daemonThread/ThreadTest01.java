package com.example.threadpool1001.daemonThread;

/**
 * @author leejalen
 * @Description 此用例用来测试多线程并发执行
 * Created on 2020/12/8
 */
public class ThreadTest01 {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(
                    () -> System.out.println(Thread.currentThread().getName())
            );
            thread.start();
        }
    }
}
