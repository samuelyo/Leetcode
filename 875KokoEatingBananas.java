package com.leetcode.KokoEatingBananas;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
//        int[] piles = {30, 11, 23, 4, 20};
//        int H = 5;
        int[] piles = {332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
        int H = 823855818;
        System.out.println(minEatingSpeed(piles, H));
    }

    public static int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        if (H < piles.length) {
            return -1;
        }
        if (H == piles.length) {
            return piles[piles.length - 1];
        }
        long left = 1;
        long right = piles[piles.length - 1];
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isValid(piles, mid, H)) {
                if (!isValid(piles, mid - 1, H)) {
                    return (int) mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return (int) left;

    }

    public static boolean isValid(int[] piles, long speed, int H) {
        if(speed == 0) {
            return false;
        }
        long sum = 0;
        for (int pile : piles) {
            sum += (pile + speed - 1) / speed;
        }
        return sum <= H;
    }
}
