package com.leetcode.ClumsyFactorial;

public class ClumsyFactorial2 {
    public static void main(String[] args) {
        System.out.println(clumsy(1));
    }

    public static int clumsy(int N) {
        if (N <= 2) {
            return N;
        } else if (N <= 4) {
            return N + 3;
        } else if ((N - 4) % 4 == 0) {
            return N + 1;
        } else if ((N - 4) % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
    }
}
