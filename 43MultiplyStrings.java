package com.leetcode.MultiplyStrings;

public class MultiplyStrings {

	public static void main(String[] args) {
		
		String num1 = "5";
		String num2 = "12";
		System.out.println(multiply(num1, num2));
		

	}

	public static String multiply(String num1, String num2) {
		
		char[] n1 = new StringBuilder(num1).reverse().toString().toCharArray();
		char[] n2 = new StringBuilder(num2).reverse().toString().toCharArray();
		
		int[] ans = new int[n1.length + n2.length];
		
		for(int i = 0;i<n1.length;i++){
			for(int j = 0;j<n2.length;j++){
				ans[i+j] += (n1[i] - '0') * (n2[j] - '0'); 
			}
		}
		
		for(int i = 0;i<ans.length;i++){
			if(ans[i] >= 10){
				ans[i + 1] += ans[i]/10;
				ans[i] = ans[i] % 10;
			}
		}
		
		int cur = ans.length - 1;
		while(cur > 0 && ans[cur] == 0){
			cur --;
		}
		
		StringBuilder ansString = new StringBuilder();
		for(int i = cur;i>=0;i--){
			ansString.append(ans[i]);
		}
		return ansString.toString();
		
	}
}
