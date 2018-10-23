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

import com.maha.ems.exception.EmployeeNotFoundException;

@RestController
@CrossOrigin
@RequestMapping("api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/*
	 * api to get all employees
	 * @return list of employee records
	 */
	@RequestMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	/*
	 * get employee record based on the employee id
	 * @param empId
	 * @return employee record
	 */
	@RequestMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") int empId) {
		try {
			return employeeService.getEmployeeById(empId);
		}catch(Exception e) {
			throw new EmployeeNotFoundException("There is no employee with such ID");
		}
	}
	
	/*
	 * api to add employee which also creates entry in empdetails
	 * @param employee
	 * @return employee object after saving in database
	 */
	@RequestMapping(method=RequestMethod.POST, value="/employees")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		LocalDate currDate=LocalDate.now();
		employee.setCreatedDate(currDate);
		employee.setLastModifiedDate(currDate);
		try {
			employee.getEmpdetails().setDateOfJoining(currDate);
			employee.getEmpdetails().setEmployee(employee);
			employee.getEmpdetails().setCreatedDate(currDate);
			employee.getEmpdetails().setLastModifiedDate(currDate);
			employee = employeeService.addEmployee(employee);
		} catch(Exception e){
			System.out.println("Exception : "+e);
		}
		return employee;
	}
	
	/*
	 * api to add employee which also updates empdetails
	 * @param employee
	 * @return employee object after updating in database
	 */
	@RequestMapping(method=RequestMethod.PUT,value="/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("id") int empId) {
		LocalDate currDate=LocalDate.now();
		Employee empRecord=employeeService.getEmployeeById(empId);
		employee.setId(empId);
		employee.getEmpdetails().setEmployee(employee);
		employee.setCreatedBy(empRecord.getCreatedBy());
		employee.setCreatedDate(empRecord.getCreatedDate());
		employee.setLastModifiedDate(currDate);
		employee.getEmpdetails().setLastModifiedDate(currDate);
		employee.getEmpdetails().setCreatedDate(empRecord.getEmpdetails().getCreatedDate());
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
