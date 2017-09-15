package com.leetcode.MaximumSwap;

public class MaximumSwap {

	public static void main(String[] args) {
		
		int num = 9973;
		System.out.println(maximumSwap(num));

	}

	public static int maximumSwap(int num) {
		
		String n = Integer.toString(num, 10);
		char[] string = n.toCharArray();
		int max = num;
		for(int i = 0;i<string.length - 1;i++){
			for(int j = i+1;j<string.length;j++){
				if(string[i] < string[j]){
					char temp = string[i];
					string[i] = string[j];
					string[j] = temp;
					int value = Integer.valueOf(String.valueOf(string));
					max = Math.max(max, value);
					char temp2 = string[i];
					string[i] = string[j];
					string[j] = temp2;
				}
			}
		}
		return max;
		
	}
}
