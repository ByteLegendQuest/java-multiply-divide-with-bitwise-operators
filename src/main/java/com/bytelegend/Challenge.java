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
        return cheng(n,32);
    }
    private static int cheng(int a,int b){
        int c = 0;
        while (a != 0){
            if((a & 1) == 1){
                c = add(c, b);
            }
            b <<= 1;
            a >>= 1;
        }
        return c;
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
        n = devide(n, 2);
        n = desic(n, 1);
        return n;

    }

    private static int add(int ja, int jb) {
        int tempJ;
        while ((tempJ = ((ja & jb) << 1)) != 0) {
            ja = ja ^ jb;
            jb = tempJ;
        }
        return ja ^ jb;
    }

    private static int desic(int a, int b) {
        return add(a, add(~b, 1));
    }

    private static int devide(int a, int b) {
        if (b == 0) {
            System.out.println("除数不能为0！");
            return -1;
        }
        int x = a < 0 ? -a : a;
        int y = b < 0 ? -b : b;
        int end = 0;
        for (int i = 31; i >= 0; i = desic(i, 1)) {
            if (y <= (x >> i)) {
                end = add(end, (1 << i));
                x = desic(x, y << i);
            }
        }
        return end;
    }
}
