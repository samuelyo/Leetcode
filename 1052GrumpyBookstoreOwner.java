package com.leetcode.GrumpyBookstoreOwner;

public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 1, 1, 0, 1, 0, 1};
        int X = 3;
        System.out.println(maxSatisfied(customers, grumpy, X));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        if (customers == null || customers.length == 0 || grumpy == null || grumpy.length == 0) {
            return 0;
        }
        int sum = 0, temp = 0;
        for (int i = 0; i < customers.length; i++) {
            if (i < X & grumpy[i] == 1) {
                temp += customers[i];
            }
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        int res = temp;
        for (int i = 1; i <= customers.length - X; i++) {
            if (grumpy[i - 1] == 1) {
                temp -= customers[i - 1];
            }
            if (grumpy[i + X - 1] == 1) {
                temp += customers[i + X - 1];
            }
            res = Math.max(res, temp);
        }
        return sum + res;
    }
}
