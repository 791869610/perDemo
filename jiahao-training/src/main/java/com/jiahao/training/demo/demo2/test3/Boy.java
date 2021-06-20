package com.jiahao.training.demo.demo2.test3;

public class Boy extends Person{

    @Override
    int make(int i) {
        System.out.println(i);
        return i;
    }

    public static void go(){
        System.out.println("boy");
    }

    public void t(){
        System.out.println("boy");
    }

    public static void main(String[] args){
        Person person = new Boy();
        person.go();
        person.t();
        person.make(1);
    }
}
