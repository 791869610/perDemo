package com.jiahao.training.demo.demo1.service;

import lombok.SneakyThrows;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class bas {

    @SneakyThrows
    public static void main(String[] args) throws IOException {
        final BASE64Encoder encoder = new BASE64Encoder();
        final BASE64Decoder decoder = new BASE64Decoder();
//        final String text = "字串文字";
//        final byte[] textByte = text.getBytes("UTF-8");
//        //编码
//        final String encodedText = encoder.encode(textByte);
//        System.out.println(encodedText);
////解码
//        System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));

        String tex = "OLSwt7k6mBmZ";
//        byte[] decode = decoder.decodeBuffer(tex);
        byte[] decode = decoder.decodeBuffer(tex);
        byte[] sb = new byte[9];
//        String[] split = tex.split("");
        for (int i = 0; i < decode.length; i++) {
            byte b = decode[i];
//            Integer i1 = ((b << 8) | (b >>> -8));
//            Integer i1 = (b<<1|b>>7);
//            Integer i1 = b>>8;
            Integer i1 = rotate_left(b,8);
            sb[i] = i1.byteValue();
            System.out.println(b + "==" + sb[i]);
        }
//        System.out.println(sb.length);
//        System.out.println(decoder.decodeBuffer("OLSwt7k6mBmZ"));
//        System.out.println(decodeBase64(tex));
//        System.out.println(decode(tex));
//        System.out.println(olSwt7k6mBmZS);

//        byte[] b={(byte)0xB8,(byte)0xDF,(byte)0xCB,(byte)0xD9};
        String str = new String(sb, "utf8");

//        String str= new String (sb);
//        System.out.println(str.split(""));
        String[] split = str.split("");
        System.out.println(split.length);
        for (int j = 0; j < split.length; j++) {
            System.out.printf(split[j]);
        }
//        System.out.println(2<<10&255);
//        System.out.println(str);
    }

    public static int rotate_left(int num, int bits) {


        int bit = num & (1 << (bits - 1));
        System.out.println("----"+bit);
        num <<= 1;
//        if (bit==null){
            num |= 1;
            num &= (2 << (bits - 1));
//        }


        return num;
    }

//
//    /**
//     * 解码
//     * @param str
//     * @return string
//     */
//    public static byte[] decode(String str){
//        byte[] bt = null;
//        try {
//            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
//            bt = decoder.decodeBuffer( str );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return bt;
//    }
//
//    /***
//     * decode by Base64
//     */
//    public static byte[] decodeBase64(String input) throws Exception{
//        Class clazz=Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
//        Method mainMethod= clazz.getMethod("decode", String.class);
//        mainMethod.setAccessible(true);
//        Object retObj=mainMethod.invoke(null, input);
//        return (byte[])retObj;
//    }
}
