package com.demo.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.demo.model.Employee;

@Service
public class EmployeeDao {

	@Autowired
	EmployeeRepo empRepo;

	/*
	 * to save employee
	 */

	public Employee save(Employee emp) {
		return empRepo.save(emp);
	}

	/*
	 * search employee
	 */

	public List<Employee> findAll() {
		return empRepo.findAll();
	}

	/*
	 * get employee
	 */

	public Optional<Employee> get(int id) {

		if (empRepo.existsById(id)) {
			return empRepo.findById(id);
		}
		return empRepo.findById(id);
	}

	/*
	 * update employee
	 */
	public Employee upgate(Employee emp) {
		if (empRepo.existsById(emp.getId())) {
			empRepo.save(emp);
		}
		return empRepo.save(emp);
	}

	/*
	 * delete employee
	 */
	public String delete(int id) {
		if (empRepo.existsById(id)) {
			empRepo.delete(empRepo.getOne(id));
			return "employee id " + id + " record deleted";
		}
		return "employee id " + id + " is not exists";
	}
}
