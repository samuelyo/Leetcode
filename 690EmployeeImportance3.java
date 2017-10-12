package com.leetcode.EmployeeImportance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class EmployeeImportance3 {

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

		if (employees == null || employees.size() == 0 || id < 0 || id > employees.size()) {
			return 0;
		}
		Collections.sort(employees, (a, b) -> a.id - b.id);
		int res = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(id);
		while (!queue.isEmpty()) {
			int curId = queue.poll();
			Employee e = employees.get(curId - 1);
			res += e.importance;
			for (int newId : e.subordinates) {
				queue.add(newId);
			}
		}
		return res;

	}

}
