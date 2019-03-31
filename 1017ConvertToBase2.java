package com.leetcode.ConvertToBase2;

public class ConvertToBase2 {
    public static void main(String[] args) {
        String res = baseNeg2(3);
        System.out.println(res);
    }

    public static String baseNeg2(int N) {
        String res = "";
        while (N != 0) {
            res = Integer.toString(N & 1) + res;
            N = -(N >> 1);
        }
        return res == "" ? "0" : res;
    }
}
