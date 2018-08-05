package com.leetcode.BoatsToSavePeople;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = {3, 5, 3, 4};
        int limit = 5;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0 || limit <= 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (people[right] == limit) {
            count++;
            right--;
        }
        while (left < right) {
            count++;
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
        }
        if (left == right) {
            count++;
        }
        return count;
    }
}
