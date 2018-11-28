package com.maha.ems.employee;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maha.ems.exception.EmployeeNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "Employees", description = "Operations pertaining to employees in EMS")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	/*
	 * api to get all employees
	 * 
	 * @return list of employee records
	 */
	@ApiOperation(value = "View the list of employees in the Organization", 
			response = List.class, 
			httpMethod = "GET")
	@RequestMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	/*
	 * get employee record based on the employee id
	 * 
	 * @param empId
	 * 
	 * @return employee record
	 */
	@ApiOperation(value = "Find employee by ID", response = Employee.class, httpMethod = "GET")
	@RequestMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") int empId) {
		try {
			return employeeService.getEmployeeById(empId);
		} catch (Exception e) {
			logger.error("There is no employee with such employee Id");
			throw new EmployeeNotFoundException("There is no employee with such employee Id");
		}
	}

	/*
	 * api to add employee which also creates entry in empdetails
	 * 
	 * @param employee
	 * 
	 * @return employee object after saving in database
	 */
	@ApiOperation(value = "Add an employee", response = Employee.class, httpMethod = "POST")
	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		LocalDate currDate = LocalDate.now();
		try {
			employee.setCreatedDate(currDate);
			employee.setLastModifiedDate(currDate);
			employee.getEmpdetails().setDateOfJoining(currDate);
			employee.getEmpdetails().setEmployee(employee);
			employee.getEmpdetails().setCreatedDate(currDate);
			employee.getEmpdetails().setLastModifiedDate(currDate);
			employee = employeeService.addEmployee(employee);
		} catch (Exception e) {
			logger.error("Error occurred while saving employee record : " + e);
		}
		return employee;
	}

	/*
	 * api to add employee which also updates empdetails
	 * 
	 * @param employee
	 * 
	 * @return employee object after updating in database
	 */
	@ApiOperation(value = "Update employee details based on ID", httpMethod = "PUT", response = Employee.class)
	@RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") int empId) {
		LocalDate currDate = LocalDate.now();
		Employee empRecord = null;
		try {
			empRecord = employeeService.getEmployeeById(empId);
		} catch (Exception e) {
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
	 * api to set or reset password this would be useful when login module is
	 * implemented
	 * 
	 * @param empId
	 * 
	 * @return employee record with the updated password
	 */
	@ApiOperation(value = "Update password", response = Employee.class, httpMethod = "PUT")
	@RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}/update-pwd")
	public Employee updatePassword(@RequestBody Employee employee, @PathVariable("id") int empId) {
		Employee employeeRecord = null;
		try {
			employeeRecord = employeeService.getEmployeeById(empId);
		} catch (Exception e) {
			logger.error("No such employee exists with such employee Id");
			throw new EmployeeNotFoundException("No such employee exists with such employee Id");
		}
		if (employeeRecord != null && employee != null) {
			employeeRecord.setPassword(employee.getPassword());
		}
		try {
			employee = employeeService.updatePassword(empId, employeeRecord);
		} catch (Exception e) {
			logger.error("Password could not be updated for the employee record with empId:" + empId);
		}
		return employee;
	}

	/*
	 * api to delete employee as of now we have direct deletion in future should
	 * implement
	 */
	@ApiOperation(value = "Delete an employee by ID", response = String.class, httpMethod = "DELETE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
	public String deleteEmployee(@PathVariable("id") int empId) {
		try {
			employeeService.deleteEmployeeById(empId);
		} catch (Exception e) {
			logger.error("Exception arised while deleting the employee record with empId : " + empId);
			return "Error occurred while deleting employee record.";
		}
		return "Successfully deleted...";
	}
}
