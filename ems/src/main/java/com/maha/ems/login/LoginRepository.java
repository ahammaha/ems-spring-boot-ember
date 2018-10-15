package com.maha.ems.login;

import org.springframework.data.repository.CrudRepository;

import com.maha.ems.employee.Employee;

public interface LoginRepository extends CrudRepository<Employee, Integer> {

}
