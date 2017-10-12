package com.leetcode.EmployeeImportance;

import java.util.ArrayList;
import java.util.List;

public class EmployeeImportance {

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
		
		Employee idEmployee = null;
		for(int i = 0;i<employees.size();i++) {
			if(employees.get(i).id == id) {
				idEmployee = employees.get(i);
			}
		}
		if(idEmployee == null) {
			return 0;
		}
		List<Integer> list = idEmployee.subordinates;
		int sum = idEmployee.importance;
		if(list == null || list.size() == 0) {
			return sum;
		}else {
			for(int i = 0;i<list.size();i++) {
				sum += getImportance(employees, list.get(i));
			}
			return sum;
		}
		
	}

}
