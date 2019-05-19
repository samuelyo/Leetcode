package com.leetcode.RemoveAllAdjacentDuplicatesInString;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        String S = "abbaca";
        String res = removeDuplicates(S);
        System.out.println(res);
    }

    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        char[] chs = S.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char cur = chs[i];
            boolean flag = true;
            while (stack.size() > 0 && stack.peek() == cur) {
                stack.pop();
                flag = false;
            }
            if (flag) {
                stack.push(cur);
            }
        }
        String res = new String();
        while (stack.size() != 0) {
            char cur = stack.pop();
            res = cur + res;
        }
        return res;
    }
}
