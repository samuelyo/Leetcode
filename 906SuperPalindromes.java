package com.leetcode.SuperPalindromes;

import java.util.LinkedList;
import java.util.List;

public class SuperPalindromes {
    public static void main(String[] args) {
        String L = "4";
        String R = "1000";
        int res = superpalindromesInRange(L, R);
        System.out.println(res);
    }

    public static int superpalindromesInRange(String L, String R) {
        Long l = Long.valueOf(L), r = Long.valueOf(R);
        int result = 0;
        for (long i = (long) Math.sqrt(l); i * i <= r; ) {
            long p = nextP(i);
            if (p * p <= r && isP(p * p)) {
                result++;
            }
            i = p + 1;
        }
        return result;
    }

    private static long nextP(long l) {
        String s = "" + l;
        int len = s.length();
        List<Long> cands = new LinkedList<>();
        cands.add((long) Math.pow(10, len) - 1);
        String half = s.substring(0, (len + 1) / 2);
        String nextHalf = "" + (Long.valueOf(half) + 1);
        String reverse = new StringBuilder(half.substring(0, len / 2)).reverse().toString();
        String nextReverse = new StringBuilder(nextHalf.substring(0, len / 2)).reverse().toString();
        cands.add(Long.valueOf(half + reverse));
        cands.add(Long.valueOf(nextHalf + nextReverse));
        long result = Long.MAX_VALUE;
        for (long i : cands) {
            if (i >= l) {
                result = Math.min(result, i);
            }
        }
        return result;
    }

    private static boolean isP(long l) {
        String s = "" + l;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
