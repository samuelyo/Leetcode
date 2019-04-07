package com.leetcode.RemoveOutermostParentheses;

public class RemoveOutermostParentheses2 {
    public static void main(String[] args) {
        String res = removeOuterParentheses("(()())(())(()(()))");
        System.out.println(res);
    }

    public static String removeOuterParentheses(String S) {
        int count = 0;
        int last = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                count++;
            } else {
                count--;
                if (count == 0) {
                    sb.append(S.substring(last + 1, i));
                    last = i + 1;
                }
            }
        }
        return sb.toString();
    }
}
