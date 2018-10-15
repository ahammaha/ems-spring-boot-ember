package com.maha.ems.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpDetailsRepository extends JpaRepository<EmpDetails, Integer> {
	EmpDetails findByEmployeeId(int empId);
}
