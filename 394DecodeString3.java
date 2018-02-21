package com.leetcode.DecodeString;

public class DecodeString3 {

	public static void main(String[] args) {
		
		String s = "3[a]2[bc]";
		System.out.println(decodeString(s));

	}
	
	public static String decodeString(String s) {
		
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while(index < s.length()) {
			char cur = s.charAt(index);
			if(cur - '0' >= 0 && cur - '0' <= 9) {
				int temp = index;
				while(temp < s.length() && s.charAt(temp) - '0' >= 0 && s.charAt(temp) - '0' <= 9) {
					temp ++;
				}
				int times = Integer.valueOf(s.substring(index, temp));
				int count = 1;
				temp ++;
				int start = temp;
				while(temp < s.length()) {
					if(s.charAt(temp) == '[') {
						count ++;
					}
					if(s.charAt(temp) == ']') {
						count --;
					}
					if(count == 0) {
						break;
					}
					temp ++;
				}
				String rep = s.substring(start, temp);
				String res = decodeString(rep);
				for(int i = 0;i<times;i++) {
					sb.append(res);
				}
				index = temp + 1;
			}else if((cur - 'a' >= 0 && cur - 'a' <= 26) || (cur - 'A' >= 0 && cur - 'A' <= 26)) {
				sb.append(cur);
				index ++;
			}
		}
		return sb.toString();
		
	}

}
