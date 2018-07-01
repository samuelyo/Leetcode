package com.leetcode.LemonadeChange;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        boolean res = lemonadeChange(bills);
        System.out.println(res);
    }

    public static boolean lemonadeChange(int[] bills) {
        int[] dp = new int[3];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                dp[0]++;
            } else if (bills[i] == 10) {
                dp[1]++;
                if (dp[0] > 0) {
                    dp[0]--;
                } else {
                    return false;
                }
            } else {
                dp[2]++;
                if (dp[0] > 0 && dp[1] > 0) {
                    dp[0]--;
                    dp[1]--;
                } else if(dp[0] > 3){
                    dp[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
