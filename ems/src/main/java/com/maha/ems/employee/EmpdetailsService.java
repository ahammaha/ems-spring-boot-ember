package com.maha.ems.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpdetailsService {

	@Autowired
	private EmpdetailsRepository empDetailsRepository;

	public Empdetails getEmpDetails(int empId) {
		return empDetailsRepository.findByEmployeeId(empId);
	}

	public Empdetails addEmpDetails(Empdetails empDetails) {
		return empDetailsRepository.save(empDetails);
	}
}