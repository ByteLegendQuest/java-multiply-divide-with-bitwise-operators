package com.bytelegend;

public class Challenge {
    public static void main(String[] args) {
        System.out.println(multiplyBy31(0));
        System.out.println(multiplyBy31(1));
        System.out.println(multiplyBy31(5));
        System.out.println(divideBy2ThenMinus1(1));
        System.out.println(divideBy2ThenMinus1(4));
        System.out.println(divideBy2ThenMinus1(7));
    }

    public static int multiplyBy31(int n) {
        int temp = n;
        int temp1 = 1;
        for (int i = 0; i < 30; i -= -temp1) {
            n -= -temp ;
        }
        return n;
    }

    public static int divideBy2ThenMinus1(int n) {
        int temp = 2;
        int temp1 = 1;
        int ram = 0;
        if (n >= 2 ) {
            while(n > 1) {
                n -= temp;
                ram -= -temp1;
            }
        }
        if (n <= 2) {
            while(n < -1) {
                n -= -temp;
                ram -= temp1;
            }
        }
        return ram - 1;
    }
}
