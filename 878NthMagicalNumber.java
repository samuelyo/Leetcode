package com.leetcode.NthMagicalNumber;

public class NthMagicalNumber {
    public static void main(String[] args) {
        System.out.println(nthMagicalNumber(1, 2, 3));
    }

    public static int nthMagicalNumber(int N, int A, int B) {
        long a = A, b = B, tmp, l = 2, r = (long) Math.pow(10, 14);
        while (b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        while (l < r) {
            long m = (l + r) / 2;
            if (m / A + m / B - m / (A * B / a) < N) {
                l = m + 1;
            } else r = m;
        }
        return (int) (l % (long) (Math.pow(10, 9) + 7));
    }
}
