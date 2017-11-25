package com.leetcode.ConvertANumberToHexadecimal;

public class ConvertANumberToHexadecimal3 {

	public static void main(String[] args) {
		
		int num = -26;
		String res = toHex(num);
		System.out.println(res);

	}

	public static char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	
	public static String toHex(int num) {
		
		StringBuilder res = new StringBuilder();
		String binary = Integer.toBinaryString(num);
		for(int i = binary.length();i>0;i-=4) {
			String temp = "";
			if(i >= 4) {
				temp = binary.substring(i - 4, i);
			}else {
				temp = binary.substring(0, i);
				int diff = 4 - temp.length();
				for(int j = 0;j<diff;j++) {
					temp = '0' + temp;
				}
			}
			char cur = toHexFromBinary(temp);
			res.insert(0, cur);
		}
		return res.toString();
		
	}
	
	public static char toHexFromBinary(String temp) {
		
		int sum = 0;
		for(int i = 0;i<4;i++) {
			sum += (temp.charAt(i) - '0') * Math.pow(2, 3 - i);
		}
		return chars[sum];
	}
}
