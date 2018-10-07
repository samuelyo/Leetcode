package com.leetcode.ReverseOnlyLetters;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String S = "Test1ng-Leet=code-Q!";
        String res = reverseOnlyLetters(S);
        System.out.println(res);
    }

    public static String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        char[] chs = S.toCharArray();
        int left = 0;
        int right = chs.length - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(chs[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(chs[right])) {
                right--;
            }
            char temp = chs[left];
            chs[left] = chs[right];
            chs[right] = temp;
            left++;
            right--;
        }
        return new String(chs);
    }
}
