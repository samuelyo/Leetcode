package com.leetcode.ComplementOfBase10Integer;

public class ComplementOfBase10Integer2 {
    public static void main(String[] args) {
        int res = bitwiseComplement(5);
        System.out.println(res);
    }

    public static int bitwiseComplement(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return X - N;
    }
}
