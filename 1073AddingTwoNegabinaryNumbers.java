package com.leetcode.AddingTwoNegabinaryNumbers;

import java.util.Arrays;
import java.util.Stack;

public class AddingTwoNegabinaryNumbers {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 1, 1};
        int[] arr2 = {1, 0, 1};
        int[] res = addNegabinary(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = arr2.length - 1, carry = 0;
        Stack<Integer> stack = new Stack<>();
        while (i >= 0 || j >= 0 || carry != 0) {
            int v1 = i >= 0 ? arr1[i--] : 0;
            int v2 = j >= 0 ? arr2[j--] : 0;
            carry = v1 + v2 + carry;
            stack.push(carry & 1);
            carry = -(carry >> 1);
        }
        while (!stack.isEmpty() && stack.peek() == 0) stack.pop();
        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res.length == 0 ? new int[1] : res;
    }
}
