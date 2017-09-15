package com.leetcode.KthSmallestNumberInMultiplicationTable;

public class KthSmallestNumberInMultiplicationTable2 {

	public static void main(String[] args) {

		int m = 2;
		int n = 3;
		int k = 5;
		System.out.println(findKthNumber(m, n, k));

	}

	public static int findKthNumber(int m, int n, int k) {

		int low = 1;
		int high = m * n + 1;
		while(low < high){
			int mid = (high - low) / 2 + low;
			if(findKthNumberHelp(m, n, mid) < k){
				low = mid + 1;
			}else {
				high = mid;
			}
		}
		return low;

	}

	public static int findKthNumberHelp(int m, int n, int mul) {

		int count = 0;
		int j = n;
		for(int i = 1;i<=m;i++){
			while(j > 0 && i * j > mul){
				j --;
			}
			count += j;
		}
		return count;

	}

}
