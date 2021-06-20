package com.jiahao.training.demo.demo1.service;

import lombok.SneakyThrows;
import sun.misc.BASE64Decoder;

import java.io.IOException;

public class gg {
    @SneakyThrows
    public static void main(String[] args) throws IOException {
        final BASE64Decoder decoder = new BASE64Decoder();

        String tex = "OLSwt7k6mBmZ";
        byte[] decode = decoder.decodeBuffer(tex);
        byte[] sb = new byte[9];
        for(int i=0;i<decode.length;i++){
            byte b = decode[i];
            Integer i1 = ((b<<1&255)|(b>>7));
            sb[i]=i1.byteValue();
            System.out.println(b +"=="+sb[i]);
        }
        String str= new String (sb, "utf8");
        String[] split = str.split("");
        System.out.println(split.length);
        for(int j=0;j<split.length;j++){
            System.out.printf("", split[j]);
        }
        System.out.println(str);
    }
}
