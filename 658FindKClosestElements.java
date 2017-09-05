package com.leetcode.FindKClosestElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Element {
	
	int value;
	int diff;
	
	Element(int v, int d){
		value = v;
		diff = d;
	}
	
}
public class FindKClosestElements {

	public static void main(String[] args) {
		
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		
		int k = 4;
		int x = -1;
		
		List<Integer> res = findClosestElements(arr, k, x);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " ");
		}
		
	}
	
	public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
		
		List<Element> list = new ArrayList<Element>();
		for(int i = 0;i<arr.size();i++){
			list.add(new Element(arr.get(i), Math.abs(arr.get(i) - x)));
		}
		Collections.sort(list, new Comparator<Element>(){

			@Override
			public int compare(Element e1, Element e2) {
				
				return e1.diff - e2.diff;
			}
			
		});
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0;i<k;i++){
			res.add(list.get(i).value);
		}
		Collections.sort(res);
		return res;
		
	}

}
