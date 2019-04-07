package com.leetcode.RemoveOutermostParentheses;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String res = removeOuterParentheses("(()())(())(()(()))");
        System.out.println(res);
    }

    public static String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }
}
