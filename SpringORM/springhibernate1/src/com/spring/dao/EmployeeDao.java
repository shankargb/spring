package com.spring.dao;

import com.spring.model.Employee;

public interface EmployeeDao {

	public String insert(Employee emp);

	public Employee search(int eno);

	public String update(Employee emp);

	public String delete(Employee emp);
}
