package com.royasoft.api.impl;

import com.royasoft.api.MyPredicate;
import com.royasoft.entity.Employee;

public class FilterEmployeeForAge implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getAge() <= 35;
	}

}
