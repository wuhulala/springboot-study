package com.wuhulala.springboot.transcation.service;

import java.util.concurrent.CountDownLatch;

/**
 * 功能说明: com.wuhulala.springboot.transcation.service<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/19<br>
 */
public class Hahaha {
    public static void main(String[] args) {
        CountDownLatch stop = new CountDownLatch(2);
        new Thread(() -> {
            System.out.println("11111111111111111");

            stop.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("222222222222222222");
            stop.countDown();
        }).start();
        System.out.println(stop.getCount());
        try {
            stop.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(stop.getCount());
    }
}
