package com.leetcode.ConvertToBase2;

public class ConvertToBase22 {
    public static void main(String[] args) {
        String res = baseNeg2(3);
        System.out.println(res);
    }

    public static String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        String res = "";
        while (N != 0) {
            int remain = N % (-2);
            N = N / (-2);
            if (remain < 0) {
                remain += 2;
                N++;
            }
            res = remain + res;
        }
        return res;
    }
}
