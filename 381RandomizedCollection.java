package com.leetcode.InsertDeleteGetRandomO1DuplicatesAllowed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedCollection {

	public List<Integer> list;
	public Map<Integer,Integer> map;
	
	/** Initialize your data structure here. */
    public RandomizedCollection() {
        
    	list = new ArrayList<Integer>();
    	map = new HashMap<Integer,Integer>();
  
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        
    	list.add(val);
    	if(map.containsKey(val)) {
    		int times = map.get(val);
    		map.put(val, times + 1);
    		return false;
    	}else{
    		map.put(val, 1);
    		return true;
    	}
    	
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        
    	if(map.containsKey(val)){
    		int times = map.get(val);
    		if(times - 1 == 0) {
    			map.remove(val);
    		}else{
    			map.put(val, times - 1);
    		}
    		list.remove(new Integer(val));
    		return true;
    	}else{
    		return false;
    	}
    	
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        
    	int random = (int) (Math.random() * list.size());
    	return list.get(random);
    	
    }
    
}
