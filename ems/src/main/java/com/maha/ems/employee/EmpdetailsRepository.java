package com.maha.ems.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpdetailsRepository extends JpaRepository<Empdetails, Integer> {
	Empdetails findByEmployeeId(int empId);
}
