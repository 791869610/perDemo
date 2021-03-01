package com.jiahao.training.test4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//题目: 请查看左侧代码，并按要求实现, 请实现createObject方法，执行main函数达到注释中想要输出的效果
public class ShowMeBug {

    public static void main(String[] arges) throws Exception {
        IA ia = (IA) createObject(IA.class.getName() + "$getName=Abc");
        System.out.println(ia.getName()); //方法名匹配的时候，输出“Abc”
        ia = (IA) createObject(IA.class.getName() + "$getTest=Bcd");
        System.out.println(ia.getName()); //方法名不匹配的时候，输出null

        ia = (IA) createObject(IA.class.getName() + "$getName=Bcd");
        System.out.println(ia.getName()); //输出Bcd
    }

    //请实现方法createObject，接口中"getName()"方法名仅仅是个示例，不能写死判断
    private static Object createObject(String str) throws Exception {

        return new MethodInvoker(str).getInstance(IA.class);
//        throw new Exception("还没有实现的方法");
    }

    static class MethodInvoker {

        private String str;

        MethodInvoker(String str) {
            this.str = str;
        }

        Object getInstance(Class clz) {
            return Proxy.newProxyInstance(
                    clz.getClassLoader(),
                    new Class[]{clz},
                    new InvokeHandlerT(str));
        }
    }

    static class InvokeHandlerT implements InvocationHandler {

        private String str;

        InvokeHandlerT(String str) {
            this.str = str;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            String[] priSplit = str.split("\\$");

            if (priSplit.length == 0) {
                throw new RuntimeException("参数不合法");
            }

            String[] afSplit = priSplit[1].split("=");

            if (afSplit.length == 0) {
                throw new RuntimeException("参数不合法");
            }

            if (method.getName().equals(afSplit[0])) {
                return afSplit[1];
            } else {
                return null;
            }
        }
    }
}
