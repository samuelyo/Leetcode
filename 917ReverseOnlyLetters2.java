package com.leetcode.ReverseOnlyLetters;

public class ReverseOnlyLetters2 {
    public static void main(String[] args) {
        String S = "Test1ng-Leet=code-Q!";
        String res = reverseOnlyLetters(S);
        System.out.println(res);
    }

    public static String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0, j = S.length() - 1; i < j; ++i, --j) {
            while (i < j && !Character.isLetter(sb.charAt(i))) ++i;
            while (i < j && !Character.isLetter(sb.charAt(j))) --j;
            if (i < j) {
                sb.setCharAt(i, S.charAt(j));
                sb.setCharAt(j, S.charAt(i));
            }
        }
        return sb.toString();
    }
}
