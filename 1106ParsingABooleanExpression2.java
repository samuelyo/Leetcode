package com.leetcode.ParsingABooleanExpression;

import java.util.*;

public class ParsingABooleanExpression2 {
    public static void main(String[] args) {
        String expression = "|(&(t,f,t),!(t))";
        System.out.println(parseBoolExpr(expression));
    }

    public static boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] chs = expression.toCharArray();
        for (char ch : chs) {
            if (ch == ')') {
                List<Character> list = new ArrayList<>();
                while (stack.peek() != '(') {
                    list.add(stack.pop());
                }
                stack.pop();
                Character sign = stack.pop();
                if (sign == '!') {
                    stack.push(list.contains('f') ? 't' : 'f');
                } else if (sign == '&') {
                    stack.push(list.contains('f') ? 'f' : 't');
                } else {
                    stack.push(list.contains('t') ? 't' : 'f');
                }
            } else if (ch != ',') {
                stack.push(ch);
            }
        }
        return stack.peek() == 't';
    }
}
