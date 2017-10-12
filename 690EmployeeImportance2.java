package com.leetcode.EmployeeImportance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance2 {

	public static void main(String[] args) {
		
		Employee e1 = new Employee();
		e1.id = 1;
		e1.importance = 5;
		e1.subordinates.add(2);
		e1.subordinates.add(3);
		
		Employee e2 = new Employee();
		e2.id = 2;
		e2.importance = 3;
		e2.subordinates = null;
		
		Employee e3 = new Employee();
		e3.id = 3;
		e3.importance = 3;
		e3.subordinates = null;
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
		System.out.println(getImportance(employees, 1));

	}
	
	public static int getImportance(List<Employee> employees, int id) {
		
		Map<Integer, Employee> idM = new HashMap<>();
	    Employee root = null;
	    for(Employee e : employees) {
	        if(e.id == id) {
	            root = e;
	        }
	        idM.put(e.id, e);
	   }
	    
	   return dfs(root, idM);
	}

	private static int dfs(Employee root, Map<Integer, Employee> idM) {
	    
		if(root == null) {
	        return 0;
	    }
	    int s = root.importance;
	    
	    for(Integer subId : root.subordinates) {
	        s += dfs(idM.get(subId), idM);
	    }
	    
	    return s;
		
	}

}
