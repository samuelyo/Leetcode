package com.leetcode.ValidateIPAddress;

public class ValidateIPAddress {

	public static void main(String[] args) {
		
		String IP = "02001:0db8:85a3:0000:0000:8a2e:0370:7334";
		String ans = validIPAddress(IP);
		System.out.println(ans);

	}
	
	public static String validIPAddress(String IP) {
		
		if(IP == null || IP.length() == 0){
			return "Neither";
		}
		if(IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':'){
			return "Neither";
		}
		if(IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.'){
			return "Neither";
		}
		
		String[] v4 = IP.split("\\.");
		String[] v6 = IP.split(":");
		
		if(v4.length == 4){
			for(int i = 0;i<4;i++){
				if(!v4[i].matches("[0-9]{1,3}")){
					return "Neither";
				}
				if(v4[i].length() != 1 && v4[i].charAt(0) == '0'){
					return "Neither";
				}
				if(!(Integer.parseInt(v4[i]) >= 0 && Integer.parseInt(v4[i]) <= 255)){
					return "Neither";
				}
			}
			return "IPv4";
		}
		
		if(v6.length == 8){
			for(int i = 0;i<8;i++){
				if(!v6[i].matches("[0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,A,B,C,D,E,F]{1,4}")){
					return "Neither";
				}
			}
			return "IPv6";
		}
		
		return "Neither";
	}

}
