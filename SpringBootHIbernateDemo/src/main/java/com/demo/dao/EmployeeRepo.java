package com.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.model.Employee;

//@RepositoryRestResource(collectionResourceRel = "employee",path="employee")
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Query(value = "select emp.id, emp.expertise,emp.emp_name,dep.name from employee as emp join department as dep on emp.department_id=dep.department_id", nativeQuery = true)
	List<Map<Object, Object>> save_emp();

}
