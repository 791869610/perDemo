package com.jiahao.training.demo.demo2.test4;

public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return instance;
    }
}
