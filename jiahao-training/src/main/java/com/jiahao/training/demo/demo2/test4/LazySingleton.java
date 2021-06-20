package com.jiahao.training.demo.demo2.test4;

public class LazySingleton {

    private static volatile LazySingleton instance = null;
    private LazySingleton(){}
    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
