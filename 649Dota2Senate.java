package com.leetcode.Dota2Senate;

public class Dota2Senate {

	public static void main(String[] args) {
		
		String senate = "RDD";
		System.out.println(predictPartyVictory(senate));

	}

	public static String predictPartyVictory(String senate) {
		
		StringBuilder sb = new StringBuilder(senate);
		while(true){
			for(int i = 0;i<sb.length();i++){
				Character cur = sb.charAt(i);
				if(cur.equals('R')){
					boolean isExist = false;
					for(int j = i+1;j<i + sb.length();j++){
						if(sb.charAt(j % sb.length()) == 'D'){
							sb.setCharAt(j % sb.length(), 'a');
							isExist = true;
							break;
						}
					}
					if(isExist == false){
						return "Radiant";
					}
				}else if(cur.equals('D')){
					boolean isExist = false;
					for(int j = i+1;j<i + sb.length();j++){
						if(sb.charAt(j % sb.length()) == 'R'){
							sb.setCharAt(j % sb.length(), 'a');
							isExist = true;
							break;
						}
					}
					if(isExist == false){
						return "Dire";
					}
				}
			}
			
		}
	}
}
