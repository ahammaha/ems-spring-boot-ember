package com.maha.ems.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	@RequestMapping("/empdetails")
	public Empdetails getEmpDetails(@PathVariable("empid") int empId) {
		return empDetailsService.getEmpDetails(empId);
	}

	/*
	 * api to add employee details record
	 * @param empDetails, empId
	 * @return empDetails object after saving in database
	 */
	@RequestMapping(method=RequestMethod.POST,value="/empdetails")
	public Empdetails addEmpDetails(@RequestBody Empdetails empDetails, @PathVariable("empid") int empId) {
		empDetails.setEmployee(employeeService.getEmployeeById(empId));
		return empDetailsService.addEmpDetails(empDetails);
	}
}
