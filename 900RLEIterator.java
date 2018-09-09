package com.leetcode.RLEIterator;

public class RLEIterator {
    int[] nums;
    int curIndex = 0;

    public RLEIterator(int[] A) {
        nums = A;
    }

    public int next(int n) {
        while(curIndex < nums.length && n > nums[curIndex]) {
            n -= nums[curIndex];
            curIndex += 2;
        }
        if(curIndex >= nums.length) {
            return -1;
        }
        nums[curIndex] -= n;
        return nums[curIndex + 1];
    }
}
