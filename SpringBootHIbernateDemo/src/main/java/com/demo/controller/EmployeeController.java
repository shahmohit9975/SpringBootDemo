package com.demo.controller;

import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;

@RestController
//@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDao empDao;

	// save employee
	@PostMapping(path = "/employees", consumes = { "application/json" }, produces = "application/json")
//	@PostMapping(path = "/employees", consumes = {"application/json","application/x-www-form-urlencoded"}, produces = "application/json")
//	@PostMapping(path = "/employees", consumes = { "application/json" })
	public ModelAndView createEmployee(@RequestBody Employee emp) {
		empDao.save(emp);
		ModelAndView mv = new ModelAndView("success.jsp");
		return mv;
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

	// ============================================================================================

	@RequestMapping("/goEmployee")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("AddEmployee1.jsp");
		return mav;
	}

	// ============================================================================================
	@RequestMapping(value = "/process", method = RequestMethod.GET)
	public List<Map<Object, Object>> process() throws Exception {

		System.out.println();

		return empDao.temp_save();
	}

	@PostMapping(path = "/temp", consumes = { "application/json" }, produces = "application/json")
	public String Temp(@RequestBody String temp) {

		System.out.println(temp);
		return temp;
	}
}
