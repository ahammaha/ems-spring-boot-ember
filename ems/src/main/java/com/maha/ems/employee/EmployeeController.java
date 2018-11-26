package com.maha.ems.employee;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maha.ems.exception.EmployeeNotFoundException;

@RestController
@CrossOrigin
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	
	/*
	 * api to get all employees
	 * @return list of employee records
	 */
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	/*
	 * get employee record based on the employee id
	 * @param empId
	 * @return employee record
	 */
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") int empId) {
		try {
			return employeeService.getEmployeeById(empId);
		}catch(Exception e) {
			logger.error("There is no employee with such employee Id");
			throw new EmployeeNotFoundException("There is no employee with such employee Id");
		}
	}
	
	/*
	 * api to add employee which also creates entry in empdetails
	 * @param employee
	 * @return employee object after saving in database
	 */
	@PostMapping("/employees")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		LocalDate currDate=LocalDate.now();
		try {
			employee.setCreatedDate(currDate);
			employee.setLastModifiedDate(currDate);
			employee.getEmpdetails().setDateOfJoining(currDate);
			employee.getEmpdetails().setEmployee(employee);
			employee.getEmpdetails().setCreatedDate(currDate);
			employee.getEmpdetails().setLastModifiedDate(currDate);
			employee = employeeService.addEmployee(employee);
		} catch(Exception e){
			logger.error("Error occurred while saving employee record : "+e);
		}
		return employee;
	}
	
	/*
	 * api to add employee which also updates empdetails
	 * @param employee
	 * @return employee object after updating in database
	 */
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("id") int empId) {
		LocalDate currDate=LocalDate.now();
		Employee empRecord = null;
		try {
			empRecord=employeeService.getEmployeeById(empId);
		}catch(Exception e) {			
			logger.error("No such employee exists with such employee Id");
			throw new EmployeeNotFoundException("No such employee exists with such employee Id");
		}
		if (employee != null) {
			employee.setId(empId);
			employee.setLastModifiedDate(currDate);
			if (employee.getEmpdetails() != null) {
				employee.getEmpdetails().setEmployee(employee);
				employee.getEmpdetails().setLastModifiedDate(currDate);
				employee.getEmpdetails().setCreatedDate(empRecord.getEmpdetails().getCreatedDate());
			}
			employee.setCreatedBy(empRecord.getCreatedBy());
			employee.setCreatedDate(empRecord.getCreatedDate());
			try {
				employee = employeeService.updateEmployee(employee);
			} catch (Exception e) {
				logger.error("Employee record could not be updated. :" + e);
			}
		}
		return employee;
	}
	
	/*
	 * api to set or reset password this would be useful when login module is implemented
	 * @param empId
	 * @return employee record with the updated password
	 */
	@PutMapping("/employees/{id}/update-pwd")
	public Employee updatePassword(@RequestBody Employee employee,@PathVariable("id") int empId) {
		Employee employeeRecord = null;
		try {
			employeeRecord = employeeService.getEmployeeById(empId);
		} catch (Exception e) {
			logger.error("No such employee exists with such employee Id");
			throw new EmployeeNotFoundException("No such employee exists with such employee Id");
		}
		if(employeeRecord!=null && employee!=null) {
			employeeRecord.setPassword(employee.getPassword());
		}
		try {
			employee = employeeService.updatePassword(empId, employeeRecord);
		} catch (Exception e) {
			logger.error("Password could not be updated for the employee record with empId:"+empId);
		}
		return employee;
	}
	
	/*
	 * api to delete employee as of now we have direct deletion 
	 * in future should implement 
	 */
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable("id") int empId) {
		try {
			employeeService.deleteEmployeeById(empId);
		} catch (Exception e) {
			logger.error("Exception arised while deleting the employee record with empId : "+empId);
			return "Error occurred while deleting employee record.";
		}
		return "Successfully deleted...";
	}
}
