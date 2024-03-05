package com.sprint.bspro.service;

import java.util.List;

import com.sprint.bspro.entity.Employee;

public interface IEmployeeService {
	public Employee createEmployee(Employee emp);
	public Employee updateEmployeeById(Employee emp, int id);
	public Employee getEmployeeById(int id);
	public void deleteEmployeeById(int id);
	public List<Employee> getAllEmployee();
}
