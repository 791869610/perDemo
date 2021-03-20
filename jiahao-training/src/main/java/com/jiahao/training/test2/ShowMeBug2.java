package com.jiahao.training.test2;

import java.util.concurrent.CountDownLatch;

public class ShowMeBug2 {
    private double balance; // 账户余额

    /**
     * 存款
     *
     * @param money 存入金额
     */
    public void deposit(double money) {
        //请输入实现存钱逻辑
        synchronized (this) {
            balance = balance + 1;
        }
    }

    /**
     * 获得账户余额
     */
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) throws InterruptedException {
        final ShowMeBug2 demo = new ShowMeBug2();
        CountDownLatch latch = new CountDownLatch(100);
        //100个线程同时向一个银行账户中存入一元钱
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                demo.deposit(1);
                latch.countDown();
            }).start();
        }
        latch.await();

        System.out.println("余额为：" + demo.getBalance());

    }
}
