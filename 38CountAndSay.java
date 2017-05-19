package com.leetcode.countandsay;

public class CountAndSay {

	public static void main(String[] args) {
		
		System.out.println(countAndSay(6));

	}
	
	public static String countAndSay(int n){
		
		String beg = "1";
		for(int i = 0;i<n-1;i++){
			beg = build(beg);
		}
		return beg;
		
	}

	private static String build(String beg) {
		
		StringBuilder res = new StringBuilder();
		int i = 0;
		while(i<beg.length()){
			int count = 0;
			int cur = i;
			Character index = beg.charAt(i);
			while(cur < beg.length() && index.equals(beg.charAt(cur))){
				cur ++;
				count ++;
			}
			i += count;
			res.append(count);
			res.append(index);
		}
		return res.toString();
	}
	
}
