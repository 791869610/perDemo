package com.jiahao.training.test2;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ShowMeBug {
    //题目: 实现一个类 支持100个线程同时向一个银行账户中存入一元钱
    private double balance; // 账户余额

    /**
     * 存款
     *
     * @param money 存入金额
     */
    public void deposit(double money) {
        //请输入实现存钱逻辑
        synchronized (ShowMeBug.class){
            this.balance = this.balance + money;
        }
    }

    /**
     * 获得账户余额
     */
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        //100个线程同时向一个银行账户中存入一元钱
        ShowMeBug showMeBug = new ShowMeBug();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(20,100,10, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        for (int i = 0; i < 100; i++) {
            executor.submit(()->showMeBug.deposit(1));
        }
        executor.shutdown();
        System.out.println(showMeBug.balance);
    }
}
