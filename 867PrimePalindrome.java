package com.leetcode.PrimePalindrome;

import java.util.Map;

public class PrimePalindrome {
    public static void main(String[] args) {
        System.out.println(primePalindrome(13));
    }

    public static int primePalindrome(int N) {
        if (N == 1 || N == 2) {
            return 2;
        }
        if (N % 2 == 0) {
            N++;
        }
        while (true) {
            if (isPalindrome(N) && isPrime(N)) {
                return N;
            } else {
                N += 2;
            }
            if (10000000 < N && N < 100000000)
                N = 100000001;
        }
    }

    public static boolean isPrime(int num) {
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int num) {
        String s = "" + num;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
