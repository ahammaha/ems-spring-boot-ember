package com.maha.ems.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employees/{empid}")
@CrossOrigin
public class EmpdetailsController {
	
	@Autowired 
	private EmpdetailsService empDetailsService;
	
	@Autowired
	private EmployeeService employeeService;
	
	/*
	 * api to get empdetails records
	 * @param empId
	 * @return empDetails record that belongs to empId
	 */
	@ApiOperation(value="Get employee details based on emp id",  httpMethod="GET", response=Empdetails.class)
	@GetMapping("/empdetails")
	public Empdetails getEmpDetails(@PathVariable("empid") int empId) {
		return empDetailsService.getEmpDetails(empId);
	}

	/*
	 * api to add employee details record
	 * @param empDetails, empId
	 * @return empDetails object after saving in database
	 */
	@ApiOperation(value="Add employee details for an employee",  httpMethod="POST", response=Empdetails.class)
	@PostMapping("/empdetails")
	public Empdetails addEmpDetails(@RequestBody Empdetails empDetails, @PathVariable("empid") int empId) {
		empDetails.setEmployee(employeeService.getEmployeeById(empId));
		return empDetailsService.addEmpDetails(empDetails);
	}
}
