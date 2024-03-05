package com.sprint.bspro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.bspro.entity.Employee;
import com.sprint.bspro.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	IEmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee emp) {
		if(emp != null) {
			employeeRepository.save(emp);
			return emp;
		}
		return null;	
	}

	@Override
	public Employee updateEmployeeById(Employee emp, int id) {
		if(emp!=null) {
			Employee savedEmp=employeeRepository.findById(id).get();
			if(savedEmp!=null) {
				savedEmp.setName(emp.getName());
				savedEmp.setDepartment(emp.getDepartment());
				savedEmp.setSalary(emp.getSalary());
				return employeeRepository.save(emp);
				
			}
		}
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {
		if(id != 0) {
			return employeeRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public void deleteEmployeeById(int id) {
		 employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	

}
