package com.leetcode.GuessNumberHigherOrLower;

public class GuessNumberHigherOrLower2 {

	public static void main(String[] args) {
		
	}
	
	public static int guess(int num){
		return -1;
	}
	/* The guess API is defined in the parent class GuessGame.
	   @param num, your guess
	   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
	      int guess(int num); */

	public static int guessNumber(int n) {
        
		int start = 0;
		int end = n;
		
		while(start <= end) {
			int mid = (end - start) / 2 + start;
			if(guess(mid) == 0) {
				return mid;
			}else if(guess(mid) == -1) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return start;
		
    }
}
