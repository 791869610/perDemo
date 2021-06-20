package com.jiahao.training.demo.demo2.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableFutureTest {

    public static void main(String[] args){
        //创建对象
        CallableTest callableTest = new CallableTest();
        //使用FutureTask包装CallableTest
        FutureTask<Integer> ft = new FutureTask<>(callableTest);
        for (int i = 0; i < 100; i++) {
            //输出主线程
            System.out.println(Thread.currentThread().getName() + "主线程的i为：" + i);
            //当进行到第三十次的时候开启子线程
            if(i == 30){
                Thread thread = new Thread(ft,"子线程");
                thread.start();
            }
        }
        //获取并输出子线程call()方法的返回值
        try {
            System.out.println("子线程的返回值为" + ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class CallableTest implements Callable<Integer> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(;i<100;i++){
            System.out.println(Thread.currentThread().getName() + "的变量值为：" + i);
        }
        return i;
    }
}
