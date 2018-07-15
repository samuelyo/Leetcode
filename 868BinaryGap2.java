package com.leetcode.BinaryGap;

public class BinaryGap2 {
    public static void main(String[] args) {
        System.out.println(binaryGap(8));
    }

    public static int binaryGap(int N) {
        int res = 0;
        for (int d = -32; N > 0; N /= 2, d++)
            if (N % 2 == 1) {
                res = Math.max(res, d);
                d = 0;
            }
        return res;
    }
}
