package com.leetcode.CheckIfWordIsValidAfterSubstitutions;

public class CheckIfWordIsValidAfterSubstitutions {
    public static void main(String[] args) {
        String S = "aabcbc";
        boolean res = isValid(S);
        System.out.println(res);
    }

    public static boolean isValid(String S) {
        String abc = "abc";
        while (S.contains(abc)) {
            S = S.replace(abc, "");
        }
        return S.isEmpty();
    }
}
