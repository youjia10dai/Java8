package com.royasoft.api.impl;

import com.royasoft.api.MyPredicate;
import com.royasoft.entity.Employee;

public class FilterEmployeeForSalary implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getSalary() >= 5000;
	}

}
