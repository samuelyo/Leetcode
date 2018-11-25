package com.leetcode.ValidateStackSequences;

import java.util.Stack;

public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = {1, 0};
        int[] poped = {1, 0};
        boolean res = validateStackSequences(pushed, poped);
        System.out.println(res);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && index < popped.length && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
