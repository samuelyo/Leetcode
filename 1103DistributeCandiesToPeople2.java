package com.leetcode.DistributeCandiesToPeople;

public class DistributeCandiesToPeople2 {
    public static void main(String[] args) {
        int candies = 10;
        int num_people = 3;
        int[] res = distributeCandies(candies, num_people);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        for (int give = 0; candies > 0; candies -= give) {
            people[give % num_people] += Math.min(candies, ++give);
        }
        return people;
    }
}
