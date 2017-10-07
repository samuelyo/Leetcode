package com.leetcode.SelfCrossing;

import java.util.HashSet;
import java.util.Set;

public class SelfCrossing {

	static class Pair {
		
		int x;
		int y;
		Pair(int xValue, int yValue) {
			x = xValue;
			y = yValue;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
		
	}
	public static void main(String[] args) {
		
		int[] num = {1,2,3,4};
		System.out.println(isSelfCrossing(num));

	}
	
	public static boolean isSelfCrossing(int[] num) {
		
		int len = num.length;
		Set<Pair> set = new HashSet<Pair>();
		set.add(new Pair(0,0));
		int x = 0;
		int y = 0;
		for(int i = 1;i<=len;i++) {
			if(i % 4 == 1) {
				int value = num[i - 1];
				int oldY = y;
				y += value;
				for(int k = oldY + 1;k<=y;k++) {
					if(!set.add(new Pair(x, k))) {
						return true;
					}
				}
			}else if(i % 4 == 2) {
				int value = num[i - 1];
				int oldX = x;
				x -= value;
				for(int k = oldX - 1;k>=x;k--) {
					if(!set.add(new Pair(k, y))) {
						return true;
					}
				}
			}else if(i % 4 == 3) {
				int value = num[i - 1];
				int oldY = y;
				y -= value;
				for(int k = oldY - 1;k>=y;k--) {
					if(!set.add(new Pair(x, k))) {
						return true;
					}
				}
			}else {
				int value = num[i - 1];
				int oldX = x;
				x += value;
				for(int k = oldX + 1;k<=x;k++) {
					if(!set.add(new Pair(k, y))) {
						return true;
					}
				}
			}
		}
		return false;
		
	}

}
