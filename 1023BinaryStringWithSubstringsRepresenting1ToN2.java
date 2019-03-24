package com.leetcode.BinaryStringWithSubstringsRepresenting1ToN;

public class BinaryStringWithSubstringsRepresenting1ToN2 {
    public static void main(String[] args) {
        String S = "0110";
        int N = 4;
        boolean res = queryString(S, N);
        System.out.println(res);
    }

    public static boolean queryString(String S, int N) {
        for (int i = N; i > N / 2; --i)
            if (!S.contains(Integer.toBinaryString(i)))
                return false;
        return true;
    }
}
