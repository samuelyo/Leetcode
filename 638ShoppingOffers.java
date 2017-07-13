package com.leetcode.ShoppingOffers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {

	public static void main(String[] args) {
		
		List<Integer> price = new ArrayList<Integer>();
		price.add(0);
		price.add(0);
		price.add(0);
		
		List<List<Integer>> special = new ArrayList<List<Integer>>();
		List<Integer> sp1 = new ArrayList<Integer>();
		sp1.add(1);
		sp1.add(1);
		sp1.add(0);
		sp1.add(4);
		special.add(sp1);
		
		List<Integer> sp2 = new ArrayList<Integer>();
		sp2.add(2);
		sp2.add(2);
		sp2.add(1);
		sp2.add(9);
		special.add(sp2);
		
		List<Integer> needs = new ArrayList<Integer>();
		needs.add(2);
		needs.add(2);
		needs.add(1);
		
		System.out.println(shoppingOffers(price, special, needs));
	
	}

	public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		
		Map<List<Integer>,Integer> dp = new HashMap<List<Integer>,Integer>();
		for(int i = 0;i<special.size();i++){
			List<Integer> cur = special.get(i);
			Integer value = cur.get(cur.size()-1);
			cur = new ArrayList<Integer>();
			int sum = 0;
			for(int j = 0;j<price.size();j++){
				cur.add(special.get(i).get(j));
				sum += special.get(i).get(j) * price.get(j);
			}
			value = Math.min(sum, value);
			dp.put(cur, value);
		}
		return shoppingOffersHelp(dp,price,special,needs);
	}

	public static int shoppingOffersHelp(Map<List<Integer>, Integer> dp, List<Integer> price,List<List<Integer>> special, List<Integer> needs) {
		
		if(dp.containsKey(needs)){
			return dp.get(needs);
		}
		int sum = Integer.MAX_VALUE;
		boolean allCant = false;
		for(int i = 0;i<special.size();i++){
			int curPrice = special.get(i).get(special.get(i).size()-1);
			boolean flag = true;
			for(int j = 0;j<price.size();j++){
				if(needs.get(j) < special.get(i).get(j)){
					flag = false;
					break;
				}
			}
			if(flag){
				allCant = true;
				List<Integer> next = new ArrayList<Integer>();
				for(int j = 0;j<price.size();j++){
					next.add(needs.get(j) - special.get(i).get(j));
				}
				sum = Math.min(sum, curPrice + shoppingOffersHelp(dp,price,special,next));
			}
		}
		if(!allCant){
			sum = 0;
			for(int i = 0;i<needs.size();i++){
				sum += needs.get(i) * price.get(i);
			}
		}
		int preSum = 0;
		for(int i = 0;i<needs.size();i++){
			preSum += needs.get(i) * price.get(i);
		}
		sum = Math.min(sum, preSum);
		dp.put(needs, sum);
		return sum;
	}
}
