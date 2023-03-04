package com.DSA.DP;

public class Test {

    public static void increaseNum(Integer num) {
        num+=1;
    }

    public static void main(String[] args) {

        Integer num = 10;

        for(int i = 0; i<10; i++) {
            increaseNum(num);
        }

        System.out.println(num);
    }
}
