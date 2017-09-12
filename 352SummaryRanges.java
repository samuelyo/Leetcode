package com.leetcode.DataStreamAsDisjointIntervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class SummaryRanges {

	/** Initialize your data structure here. */
	
	TreeSet<Integer> set;
	
    public SummaryRanges() {
        
    	set = new TreeSet<Integer>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
    		
    	});
    	
    }
    
    public void addNum(int val) {
        
    	set.add(val);
    	
    }
    
    public List<Interval> getIntervals() {
        
    	TreeSet<Integer> temp = new TreeSet<>(set);
    	List<Interval> list = new ArrayList<Interval>();
    	Integer start = temp.first();
    	Integer end;
    	while(!temp.isEmpty()){
    		Integer cur = temp.pollFirst();
    		if(temp.size() == 0 || temp.size() != 0 && temp.first() != cur + 1){
    			end = cur;
    			list.add(new Interval(start, end));
    			if(temp.size() != 0){
    				start = temp.first();
    			}
    		}
    		
    	}
    	return list;
    	
    }
    
}
