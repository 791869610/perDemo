package com.jiahao.training.demo.demo2.test4;

public class Realizetype implements Cloneable{



    Realizetype(){
        System.out.println("具体原型创建成功");
    }

    public Object clone() throws CloneNotSupportedException{
        System.out.println("具体原型复制成功");
        return (Realizetype)super.clone();
    }
}

class Test{
    public static void main(String[] args){
        try {
            Realizetype realizetype = new Realizetype();
            Realizetype clone = (Realizetype)realizetype.clone();
            System.out.println(realizetype == clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
