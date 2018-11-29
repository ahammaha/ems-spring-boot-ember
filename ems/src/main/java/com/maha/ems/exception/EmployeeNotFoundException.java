package com.maha.ems.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String EXCEPTION_MSG = "No such employee exists with employee Id : ";

	public EmployeeNotFoundException(int empId) {
		super(EXCEPTION_MSG + empId);
	}
}
