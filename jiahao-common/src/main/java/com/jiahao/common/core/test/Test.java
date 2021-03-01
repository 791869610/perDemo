package com.jiahao.common.core.test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] arges) throws Exception {
        IA ia = (IA) createObject(IA.class.getName() + "$getName=Abc");
        System.out.println(ia.getName()); //输出Abc
        ia = (IA) createObject(IA.class.getName() + "$getName=Bcd");
        System.out.println(ia.getName()); //输出Bcd
        ia = (IA) createObject(IA.class.getName() + "$getTest=Bcd");
        System.out.println(ia.getName()); //输出null
    }

    //请实现方法createObject
    public static Object createObject(String str) throws Exception {

        String[] array = str.split("\\$");
        String[] arrayMethod = array[1].split("=");
        Class<?> iaClass = Class.forName(array[0]);
        return Proxy.newProxyInstance(
                iaClass.getClassLoader(),
                new Class[]{iaClass},
                (Object proxy, Method method, Object[] args) -> {
                    return method.getName().equals(arrayMethod[0])?arrayMethod[1]:null;
//                    if (method.getName().equals(arrayMethod[0])) {
//                        return arrayMethod[1];
//                    }
//                    return null;
                }
        );
    }

}
