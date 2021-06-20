package com.jiahao.training.demo.demo2.test6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {

    public static void main(String[] args){
        cacheThreadPool();
    }

    /**
     * 1.创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒不执行任务）的线程<br>
     * 2.当任务数增加时，此线程池又可以智能的添加新线程来处理任务<br>
     * 3.此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小<br>
     *
     */
    public static void cacheThreadPool(){
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i <= 10; i++) {
            final int ii = i;
            cacheThreadPool.execute(()->System.out.println("线程名称：" + Thread.currentThread().getName() + "，执行" + ii));
//            cacheThreadPool.execute(new TestTask());
        }
    }


}

class TestTask implements Runnable{

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */

    int i = 0;

//    public TestTask(int i) {
//        this.i = i;
//    }

    @Override
    public void run() {
        System.out.println("线程名称 ：" + Thread.currentThread().getName() + "，执行" + i);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}