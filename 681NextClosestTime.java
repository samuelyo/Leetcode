package com.leetcode.NextClosestTime;

public class NextClosestTime {

	public static void main(String[] args) {
		
		String time = "23:59";
		String res = nextClosestTime(time);
		System.out.println(res);

	}

	public static String nextClosestTime(String time) {
		
		int[] digits = new int[4];
		int count = 0;
		for(int index = 0;index < time.length();index ++) {
			if(time.charAt(index) - '0' >= 0 && time.charAt(index) - '0' <= 9) {
				digits[count] = time.charAt(index) - '0';
				count ++;
			}
		}
		String[] nowSplit = time.split(":");
		int now = Integer.valueOf(nowSplit[0]) * 60 + Integer.valueOf(nowSplit[1]);
		String min = time;
		int diff = Integer.MAX_VALUE;
		StringBuilder res = new StringBuilder();
		for(int i = 0;i<digits.length;i++) {
			for(int j = 0;j<digits.length;j++) {
				for(int k = 0;k<digits.length;k++) {
					for(int m = 0;m<digits.length;m++) {
						res.append(digits[i]).append(digits[j]).append(":").append(digits[k]).append(digits[m]);
						String[] tempSplit = res.toString().split(":");
						if(Integer.valueOf(tempSplit[0]) <= 23 && Integer.valueOf(tempSplit[0]) >= 0 && Integer.valueOf(tempSplit[1]) <= 59 && Integer.valueOf(tempSplit[1]) >= 0) {
							int temp = Integer.valueOf(tempSplit[0]) * 60 + Integer.valueOf(tempSplit[1]);
							if(temp < now) {
								temp += 24 * 60;
							}
							if(temp != now && temp - now < diff) {
								diff = temp - now;
								min = res.toString();
							}
						}
						res = new StringBuilder();
					}
				}
			}
		}
		return min;
		
	}
}
