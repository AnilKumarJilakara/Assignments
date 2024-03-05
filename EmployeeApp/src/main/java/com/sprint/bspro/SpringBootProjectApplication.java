package com.sprint.bspro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.bspro.entity.Employee;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class SpringBootProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}
	
	@Override
	public void run(String[] args) throws IOException{
		
		ObjectMapper objectMapper=new ObjectMapper();
		
		Employee employee=objectMapper.readValue(new File("Employee.json"), Employee.class);
		
		System.out.println(employee);
		
		Employee emp=new Employee();
		emp.setName("Manoj");
		emp.setDepartment("Cloud");
		emp.setSalary(36000);
		
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		objectMapper.writeValue(new File("Employee3.json"), emp);
	}
}
