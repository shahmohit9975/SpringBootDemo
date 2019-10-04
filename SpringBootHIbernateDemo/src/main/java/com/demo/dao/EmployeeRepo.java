package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.model.Employee;

//@RepositoryRestResource(collectionResourceRel = "employee",path="employee")
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
