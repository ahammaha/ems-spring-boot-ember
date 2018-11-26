package com.maha.ems.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployees() {
		List<Employee> employees=new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}
	
	public Employee getEmployeeById(int id) {
		Optional<Employee> emp=employeeRepository.findById(id);
		return emp.orElse(null);
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}

	public Employee updatePassword(int empId, Employee employee) {
		employeeRepository.save(employee);
		return null;
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
