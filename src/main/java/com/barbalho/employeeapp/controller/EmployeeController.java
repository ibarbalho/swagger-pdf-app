package com.barbalho.employeeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barbalho.employeeapp.model.Employee;
import com.barbalho.employeeapp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee emp) {
		return employeeService.createEmployee(emp);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> readEmployees() {
		return employeeService.getEmployees();
	}

	@RequestMapping(value = "/employees/{empId}", method = RequestMethod.PUT)
	public Employee readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
		return employeeService.updateEmployee(id, empDetails);
	}

	@RequestMapping(value = "/employees/{empId}", method = RequestMethod.DELETE)
	public void deleteEmployees(@PathVariable(value = "empId") Long id) {
		employeeService.deleteEmployee(id);
	}

}
