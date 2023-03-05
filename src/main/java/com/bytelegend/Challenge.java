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

    /**
     * `multiplyBy31Description(int n)` returns the result of a given integer multiplying by 31,
     * e.g. `n=1`, return `31`; `n=2`, return `62`. No need to consider overflow issue. Note that
     * you are not allowed to use multiplication sign (`*`), division sign (`/`), and addition sign
     * (`+`).
     */
    public static int multiplyBy31(int n) {
        int sum = 0;
        int a = 31;
        while (n != 0) {
            if ((n & 1) != 0) {
                sum += a;
            }
            a <<= 1;
            n >>>= 1;
        }
        return sum;
    }

    /**
     * `divideBy2ThenMinus1(int n)` returns the result of a given integer dividing by 2, then minus
     * 1.
     *
     * <p>For example, `n=1`, return `-1`, because `1/2=0`, `0-1=-1`.
     *
     * <p>`n=4`, return 1, because `4/2=2`, `2-1=1`.
     *
     * <p>Note that you are not allowed to use multiplication sign (`*`), division sign (`/`), and
     * addition sign (`+`).
     */
    public static int bitAdd(int a, int b) {
        int sum = 0;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int negNum(int n) {
        //转化为相反数
        return bitAdd(~n, 1);
    }

    public static int minus(int a, int b) {
        //实现两个数相减
        return bitAdd(a, negNum(b));
    }

    public static boolean isNeg(int n) {
        //判断是否为负数
        return n < 0;
    }

    public static int bitDiv(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = bitAdd(i, negNum(1))) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = bitAdd(x, negNum(y << i));
            }
        }
        return isNeg(a) != isNeg(b) ? negNum(res) : res;
    }

    public static int divideBy2ThenMinus1(int n) {
        return bitAdd(bitDiv(n, 2), ~1 + 1);
    }
}
