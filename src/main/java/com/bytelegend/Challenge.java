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

    public static int add(int a, int b) {
        int sum = a;
        int z = b;
        while (z != 0) {
            sum = a ^ z;    //将a，b两值不带进位相加
            z = (a & z) << 1; //b更新为进位的值
            a = sum;   //a更新为不带进位的相加值
        }
        return sum;
    }


    /**
     * `multiplyBy31Description(int n)` returns the result of a given integer multiplying by 31,
     * e.g. `n=1`, return `31`; `n=2`, return `62`. No need to consider overflow issue. Note that
     * you are not allowed to use multiplication sign (`*`), division sign (`/`), and addition sign
     * (`+`).
     */
    public static int multiplyBy31(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = add(sum, 31);
        }

        return sum;
    }

    public static int divide(int a, int b) {
        boolean isAllNeg = isNegtive(a) || isNegtive(b);
        if (isNegtive(a))
            a = add(~a, 1);
        if (isNegtive(b))
            b = add(~b, 1);
        int ans = 0;
        int temp;
        int z = b;
        if (a < z) {
            return 0;
        } else if (a == z) {
            return 1;
        } else {
            for (int i = 31; i >= 0; i--) {
                temp = a >>> i;
                if (temp >= b) {
                    ans += (1 << i);
                    a -= (z << i);
                }
            }
        }
        return isAllNeg ? add(~ans, 1) : ans;
    }

    public static boolean isNegtive(int num) {
        return num < 0;
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

        return divide(n, 2) - 1;
    }
}
