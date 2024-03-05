package com.sprint.bspro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.bspro.entity.Employee;
import com.sprint.bspro.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@PostMapping("/createEmp")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return employeeService.createEmployee(emp);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployeeById(@PathVariable int id, @RequestBody Employee emp) {
		return employeeService.updateEmployeeById(emp, id);
	}
	
	@DeleteMapping("del/{empid}")
	public void deleteEmployee(@PathVariable int empid) {
		employeeService.deleteEmployeeById(empid);
	}
	
	@GetMapping("view/{empid}")
	public Employee getEmployeeById(@PathVariable int empid) {
		return employeeService.getEmployeeById(empid);
	}
	
	@GetMapping("view")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
}
