package com.leetcode.BitwiseANDOfNumbersRange;

public class BitwiseANDOfNumbersRange {

	public static void main(String[] args) {
		
		int m = 5;
		int n = 7;
		
		System.out.println(rangeBitwiseAnd(m, n));
	}
	
	public static int rangeBitwiseAnd(int m, int n) {
		
		int i = 0;
		String mString = Integer.toBinaryString(m);
		String nString = Integer.toBinaryString(n);
		StringBuilder mSb = new StringBuilder(mString);
		for(int j = 0;j<32-mString.length();j++){
			mSb.insert(0, 0);
		}
		StringBuilder nSb = new StringBuilder(nString);
		for(int j = 0;j<32-nString.length();j++){
			nSb.insert(0, 0);
		}
		for(int j = 0;j<32;j++){
			char curM = mSb.charAt(j);
			char curN = nSb.charAt(j);
			if(curM != curN){
				break;
			}else{
				i ++;
			}
		}
		i = 32 - i;
		StringBuilder res = new StringBuilder();
		int count = 0;
		for(int j = 0;j<32;j++){
			int cur = (n >> j) & 1;
			if(count < i){
				res.append(0);
			}else{
				res.append(cur);
			}
			count ++;
		}
		return Integer.valueOf(res.reverse().toString(), 2);
		
	}

}
