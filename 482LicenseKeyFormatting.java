package com.leetcode.LicenseKeyFormatting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LicenseKeyFormatting {

	public static void main(String[] args) {
		
		String S = "2-4A0r7-4k";
		int K = 4;
		System.out.println(licenseKeyFormatting(S, K));

	}
	
	public static String licenseKeyFormatting(String S, int K) {
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<S.length();i++){
			if(S.charAt(i) == '-'){
				continue;
			}else if(S.charAt(i) - '0' >= 0 && S.charAt(i) - '0' <= 9){
				sb.append(S.charAt(i));
			}else{
				if(S.charAt(i) - 'a' >= 0 && S.charAt(i) - 'a' <= 26){
					sb.append(String.valueOf(S.charAt(i)).toUpperCase());
				}else{
					sb.append(S.charAt(i));
				}
			}
		}
		List<String> list = new ArrayList<String>();
		while(sb.length() >= K){
			list.add(sb.substring(sb.length() - K));
			int len = sb.length();
			for(int i = len-1;i>=len-K;i--){
				sb.deleteCharAt(i);
			}
		}
		if(sb.length() > 0){
			list.add(sb.toString());
		}
		Collections.reverse(list);
		StringBuilder res = new StringBuilder();
		for(int i = 0;i<list.size();i++){
			if(i == 0){
				res.append(list.get(i));
			}else{
				res.append("-" + list.get(i));
			}
		}
		return res.toString();
		
	}

}
