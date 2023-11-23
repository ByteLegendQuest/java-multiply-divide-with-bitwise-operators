package com.bytelegend;

public class Challenge {
    public static void main(String[] args) {
//        System.out.println(multiplyBy31(0));
//        System.out.println(multiplyBy31(2));
//        System.out.println(multiplyBy31(5));
        System.out.println(-97 / 2 - 1);
        System.out.println(-99 / 2 - 1);
        System.out.println(-98 / 2 - 1);
        System.out.println(divideBy2ThenMinus1(-97));
        System.out.println(divideBy2ThenMinus1(-99));
        System.out.println(divideBy2ThenMinus1(-98));
    }

    /**
     * `multiplyBy31Description(int n)` returns the result of a given integer multiplying by 31,
     * e.g. `n=1`, return `31`; `n=2`, return `62`. No need to consider overflow issue. Note that
     * you are not allowed to use multiplication sign (`*`), division sign (`/`), and addition sign
     * (`+`).
     */
    public static int multiplyBy31(int n) {
        return (n << 5) - n;
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
    public static int divideBy2ThenMinus1(int n) {
        return ((n+1) >> 1 )- 1;
    }
}
