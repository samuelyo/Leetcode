package com.leetcode.DistinctSubsequencesII;

import java.util.Arrays;

public class DistinctSubsequencesII {
    public static void main(String[] args) {
        String S = "abc";
        System.out.println(distinctSubseqII(S));
    }

    public static int distinctSubseqII(String S) {
        long end[] = new long[26], mod = (long) 1e9 + 7;
        for (char c : S.toCharArray())
            end[c - 'a'] = Arrays.stream(end).sum() % mod + 1;
        return (int) (Arrays.stream(end).sum() % mod);
    }
}
