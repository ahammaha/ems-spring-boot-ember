package com.maha.ems.employee;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="salary")
public class Salary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="basic_pay")
	private double basicPay;
	
	@Column(name="variable_pay")
	private double variablePay;
	
	@Column(name="overall_pkg")
	private double overallPkg;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id")
	private Employee employee;

	public Salary(double basicPay, double variablePay, double overallPkge) {
		this.basicPay = basicPay;
		this.variablePay = variablePay;
		this.overallPkg = overallPkg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}

	public double getVariablePay() {
		return variablePay;
	}

	public void setVariablePay(double variablePay) {
		this.variablePay = variablePay;
	}

	public double getOverallPkg() {
		return overallPkg;
	}

	public void setOverallPkg(double overallPkg) {
		this.overallPkg = overallPkg;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Salary [id=" + id + ", basicPay=" + basicPay + ", variablePay=" + variablePay + ", overallPkg="
				+ overallPkg + ", employee=" + employee + "]";
	}
	
}
