package com.sprint.bspro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.bspro.entity.Employee;
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

}
