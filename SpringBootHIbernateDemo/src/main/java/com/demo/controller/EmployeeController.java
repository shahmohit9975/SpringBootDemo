package com.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDao empDao;

	// save employee
	@PostMapping(path = "/employees", consumes = { "application/json" })
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		empDao.save(emp);
		return emp;
	}

	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {

		return empDao.findAll();	
	}

	// get employee by id
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") int id) {

		return empDao.get(id);
	}

	// delete employee
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {

		return empDao.delete(id);
	}

	// update Employee
	@PutMapping(path = "/employees", consumes = { "application/json" })
	public Employee updateAlien(@RequestBody Employee emp) {

		return empDao.save(emp);
	}
}
