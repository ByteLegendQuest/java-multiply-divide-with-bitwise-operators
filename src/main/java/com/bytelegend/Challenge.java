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
        int temp = 0;
        int temp1 = 1;
        for (int i = 0; i < 31; i -= -temp1) {
            temp -= -n;
        }
        return temp;
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
        int temp = 2;
        int temp2 = n;
        int temp1 = 1;
        int ram = 0;
        if (temp2 >= 2) {
            while (temp2 > 1) {
                temp2 -= temp;
                ram -= -temp1;
            }
        }
        if (temp2 <= -2) {
            while (temp2 < -1) {
                temp2 -= -temp;
                ram -= temp1;
            }
        }
        return ram - 1;
    }
}
