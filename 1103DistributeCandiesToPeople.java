package com.leetcode.DistributeCandiesToPeople;

public class DistributeCandiesToPeople {
    public static void main(String[] args) {
        int candies = 10;
        int num_people = 3;
        int[] res = distributeCandies(candies, num_people);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }

    public static int[] distributeCandies(int candies, int num_people) {
        int step = num_people * (num_people + 1) / 2;
        int sum = 0, count = 0;
        while (sum + step <= candies) {
            sum += step;
            step += num_people * num_people;
            count++;
        }
        int left = candies - sum;
        int[] res = new int[num_people];
        for (int i = 0; i < res.length; i++) {
            res[i] = (i + 1 + (i + 1 + (count - 1) * num_people)) * count / 2;
        }
        for (int i = 0; i < res.length; i++) {
            res[i] += (i + 1 + count * num_people);
            left -= (i + 1 + count * num_people);
            if (left < 0) {
                res[i] -= (i + 1 + count * num_people);
                left += (i + 1 + count * num_people);
                res[i] += left;
                break;
            }
        }
        return res;
    }
}
