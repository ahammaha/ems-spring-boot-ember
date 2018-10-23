package com.maha.ems.employee;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees/{empid}")
@CrossOrigin
public class EmpdetailsController {
	
	@Autowired 
	private EmpdetailsService empDetailsService;
	
	@Autowired
	private EmployeeService employeeService;
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	@RequestMapping("/empdetails")
	public Empdetails getEmpDetails(@PathVariable("empid") int empId) {
		return empDetailsService.getEmpDetails(empId);
	}

	@RequestMapping(method=RequestMethod.POST,value="/empdetails")
	public Empdetails addEmpDetails(@RequestBody Empdetails empDetails, @PathVariable("empid") int empId) {
		empDetails.setEmployee(employeeService.getEmployeeById(empId));
		return empDetailsService.addEmpDetails(empDetails);
	}
	
	/*
	@RequestMapping(method=RequestMethod.DELETE,value="/empdetails")
	public boolean deleteEmpDetails(@PathVariable("empid") int empId) {
		empDetailsService.deleteEmpDetails(empId);
		return true;
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/empdetails/{id}")
	public boolean deleteEmpDetailsById(@PathVariable("empid") int empId,@PathVariable("id") int id) {
		empDetailsService.deleteEmpDetailsById(id);
		return true;
	}*/
}
