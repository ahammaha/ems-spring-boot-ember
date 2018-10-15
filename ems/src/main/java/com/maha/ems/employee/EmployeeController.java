package com.maha.ems.employee;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@RequestMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") int empId) {
		return employeeService.getEmployeeById(empId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employees")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		LocalDate currDate=LocalDate.now();
		employee.setDateOfJoining(currDate);
		employee.setCreatedDate(currDate);
		employee.setLastModifiedDate(currDate);
		return employeeService.addEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("id") int empId) {
		employee.setid(empId);
		return employeeService.updateEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/employees/{id}/update-pwd")
	public Employee updatePassword(@RequestBody Employee employee,@PathVariable("id") int empId) {
		return employeeService.updatePassword(empId,employee);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/employees/{id}")
	public String deleteEmployee(@PathVariable("id") int empId) {
		employeeService.deleteEmployeeById(empId);
		return "Successfully deleted...";
	}
}
