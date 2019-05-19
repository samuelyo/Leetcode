package com.leetcode.RemoveAllAdjacentDuplicatesInString;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicatesInString2 {
    public static void main(String[] args) {
        String S = "abbaca";
        String res = removeDuplicates(S);
        System.out.println(res);
    }

    public static String removeDuplicates(String S) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (!dq.isEmpty() && dq.peekLast() == c) {
                dq.pollLast();
            } else {
                dq.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : dq) {
            sb.append(c);
        }
        return sb.toString();
    }
}
