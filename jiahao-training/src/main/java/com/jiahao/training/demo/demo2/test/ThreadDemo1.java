package com.jiahao.training.demo.demo2.test;

public class ThreadDemo1 {

    public static void main(String[] args){
        //创建两个线程
        ThreadDemo t1 = new ThreadDemo("zhangsan");
        ThreadDemo t2 = new ThreadDemo("lisi");
        //执行多线程特有方法，如果使用run();也会执行，但是回忆单线程方式执行
        t1.start();
        t2.start();
        //主线程
        for(int i = 0; i< 5; i++){
            System.out.println("main" + ":run" + i);
        }
    }
}

//继承thread类
class ThreadDemo extends Thread{

    //设置线程名称
    ThreadDemo(String name){
        super(name);
    }

    //重写run方法
    public void run(){
        for(int i = 0; i< 5; i++){
            System.out.println(this.getName() + ":run" + i);
        }
    }



}
