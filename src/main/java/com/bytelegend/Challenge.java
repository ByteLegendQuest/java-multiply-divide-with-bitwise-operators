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
        return mul(n,31);
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
        return sub(n>>1,1); //取反  即-1
    }

    public static int mul(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static int sub(int a, int b) {
        // 被减数取相反数，使用位运算取反~b+1即b的相反数
        b = add(~b, 1);
        // 计算a + (-b)
        return add(a, b);
    }

    public static int add(int a, int b) {
        // 表示两数相加后的和，初始状态是a
        int sum = a;
        // 表示进位，初始状态是b，也就是把b当做加和后的进位
        int carry = b;
        // 循环条件：只要进位不为0，则继续加
        while (carry != 0) {
            // 计算两数对应二进制位加和
            sum = a ^ b;
            // 记录每一位的进位信息，<<将每一位的进位信息提高一位，加入到下次对位计算中
            carry = (a & b) << 1;
            // a 重新赋值加和结果
            a = sum;
            // 记录进位
            b = carry;
        }
        return sum;
    }
}
