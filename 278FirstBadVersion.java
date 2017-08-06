package com.leetcode.FirstBadVersion;

public class FirstBadVersion {

	public static void main(String[] args) {
		
		int n = 5;
		System.out.println(firstBadVersion(n));

	}

	public static int firstBadVersion(int n) {
		
		int left = 0;
		int right = n - 1;
		
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(isBadVersion(mid)){
				if(!isBadVersion(mid - 1)){
					return mid;
				}else{
					right = mid - 1;
				}
			}else{
				left = mid + 1;
			}
		}
		return left;
		
	}
	
	public static boolean isBadVersion(int version) {
		
		if(version < 0){
			return false;
		}else{
			return true;
		}
		
	}
}
