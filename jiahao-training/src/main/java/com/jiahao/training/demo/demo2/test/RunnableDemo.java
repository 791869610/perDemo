package com.jiahao.training.demo.demo2.test;

public class RunnableDemo {


    public static void main(String[] args){
        RunTest runTest = new RunTest();
        //建立线程对象
        Thread thread1 = new Thread(runTest);
        Thread thread2 = new Thread(runTest);
        //开启线程并调用run方法
        thread1.start();
        thread2.start();

    }

}

class RunTest implements Runnable{

    private int tick = 10;

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
     *
     *
     * 覆盖Runnable接口中的run方法,并将线程要运行的代码放在该run方法中。
     */
    @Override
    public void run() {
        while (true){
            if (tick>0){
                System.out.println(Thread.currentThread().getName() + "..." + tick--);
            }
        }
    }
}