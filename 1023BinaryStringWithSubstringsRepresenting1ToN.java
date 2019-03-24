package com.leetcode.BinaryStringWithSubstringsRepresenting1ToN;

public class BinaryStringWithSubstringsRepresenting1ToN {
    public static void main(String[] args) {
        String S = "0110";
        int N = 4;
        boolean res = queryString(S, N);
        System.out.println(res);
    }

    public static boolean queryString(String S, int N) {
        for (int i = 1; i <= N; i++) {
            String cur = Integer.toBinaryString(i);
            if (S.indexOf(cur) == -1) {
                return false;
            }
        }
        return true;
    }
}
