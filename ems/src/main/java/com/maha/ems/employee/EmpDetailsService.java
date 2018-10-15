package com.maha.ems.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpDetailsService {

	@Autowired
	private EmpDetailsRepository empDetailsRepository;

	public EmpDetails getEmpDetails(int empId) {
		return empDetailsRepository.findByEmployeeId(empId);
	}

	public EmpDetails addEmpDetails(EmpDetails empDetails) {
		return empDetailsRepository.save(empDetails);
	}
	
	/*
	public void deleteEmpDetails(int empId) {
		empDetailsRepository.deleteEmpDetailsByEmpId(empId);
	}*/
	
	/*
	public void deleteEmpDetailsById(int id) {
		empDetailsRepository.deleteById(id);
	}
	*/
}
