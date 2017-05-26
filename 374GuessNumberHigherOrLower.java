package com.leetcode.GuessNumberHigherOrLower;

public class GuessNumberHigherOrLower {

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
        
		int left = 0;
		int right = n;
		while(left <= right){
			int middle = left + (right - left)/2;
			if(guess(middle) == 0){
				return middle;
			}
			if(guess(middle) == 1){
				left = middle + 1;
			}else{
				right = middle - 1;
			}
		}
		return right;
    }
}
