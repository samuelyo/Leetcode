package com.leetcode.BoatsToSavePeople;

import java.util.Arrays;

public class BoatsToSavePeople2 {
    public static void main(String[] args) {
        int[] people = {3, 5, 3, 4};
        int limit = 5;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        if (people == null) return 0;
        Arrays.sort(people);
        int count = 0, left = 0, right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit)
                left++;
            right--;
            count++;
        }
        return count;
    }
}
