package com.leetcode.KokoEatingBananas;

import java.util.Arrays;

public class KokoEatingBananas2 {
    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int H = 5;
        System.out.println(minEatingSpeed(piles, H));
    }

    public static int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        long total = 0;
        for (int pile : piles) total += pile;
        int min = (int) Math.ceil(total / (double) H);
        int max = piles[piles.length - 1];
        while (min < max) {
            if (canFinish(piles, min, H)) return min;
            if (canFinish(piles, (min + max) / 2, H)) max = (min + max) / 2;
            else min = (min + max) / 2 + 1;
        }
        return (int) min;
    }


    private static boolean canFinish(int[] piles, int speed, int target) {
        long counter = 0;
        for (int pile : piles) {
            counter += Math.ceil(pile / (double) speed);
        }
        return (int) counter <= target;
    }
}
