package com.leetcode.GrumpyBookstoreOwner;

public class GrumpyBookstoreOwner2 {
    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 1, 1, 0, 1, 0, 1};
        int X = 3;
        System.out.println(maxSatisfied(customers, grumpy, X));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfy = 0, max = 0;
        for (int i = 0, win = 0; i < grumpy.length; ++i) {
            satisfy += grumpy[i] == 0 ? customers[i] : 0;
            win += grumpy[i] == 1 ? customers[i] : 0;
            if (i >= X) {
                win -= grumpy[i - X] == 1 ? customers[i - X] : 0;
            }
            max = Math.max(win, max);
        }
        return satisfy + max;
    }
}
