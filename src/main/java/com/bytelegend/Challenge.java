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
        return (n << 5) - n;
    }

    /**
@@ -32,6 +35,6 @@ public static int multiplyBy31(int n) {
     * addition sign (`+`).
     */
    public static int divideBy2ThenMinus1(int n) {
        if (n < 0){
            n = -n;
            return -((n >> 1) - 1) - 3;
        }
        return (n >> 1) - 1;
}
