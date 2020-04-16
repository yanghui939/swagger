package com.yh.test;

public class TestInteger {
    public static void main(String[] args) {
        Integer a = 1000;
        Integer b = 1000;
        Integer c = 127;
        Integer d = 127;
        System.out.println(a==b);   //false   缓冲区为-128-127 不在范围内表示新new了一个Integer对象，内存地址不相同
        System.out.println(c==d);   //true   缓冲区为-128-127 在范围内表示没有新new了一个Integer对象，内存地址相同
        Integer e = new Integer(127);
        Integer f = 127;
        int g = 127;
        System.out.println(e==f);   //false  新new了对象，内存地址不同
        System.out.println(e==g);   //true  自动拆箱为int类型，==比较的是值，只要值相等就可以
    }

}
