package com.jiahao.training.test4;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class ShowMeBug2 {
    public static void main(String[] arges) throws Exception {
        IA ia = (IA) createObject(IA.class.getName() + "$getName=Abc");
        System.out.println(ia.getName()); //方法名匹配的时候，输出“Abc”
        ia = (IA) createObject(IA.class.getName() + "$getTest=Bcd");
        System.out.println(ia.getName()); //方法名不匹配的时候，输出null
        ia = (IA) createObject(IA.class.getName() + "$getName=Bcd");
        System.out.println(ia.getName()); //输出Bcd
    }

    //请实现方法createObject，接口中"getName()"方法名仅仅是个示例，不能写死判断
    public static Object createObject(String str) throws Exception {
        if (Objects.isNull(str)) {
            throw new RuntimeException("error");
        }
        final String methodName = str.replaceAll("^.*\\$(.*)=.+$", "$1");
        final String outStr = str.replaceAll("^.*=(.+)$", "$1");
        return new IA() {
            @Override
            public String getName() {

                Method[] methods = IA.class.getDeclaredMethods();
                Method targetMethod = null;
                for (Method method : methods) {
                    if (!Arrays.asList("toString", "getClass", "hashCode", "notify", "notifyAll", "wait").contains(method.getName())) {
                        targetMethod = method;
                    }
                }
                if (Objects.isNull(targetMethod)) {
                    throw new RuntimeException("error");
                }
                if (methodName.equals(targetMethod.getName())) {
                    return outStr;
                }
                return null;
            }
        };
    }
}
