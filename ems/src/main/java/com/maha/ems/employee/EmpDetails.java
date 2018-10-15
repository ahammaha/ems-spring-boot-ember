package com.maha.ems.employee;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="emp_details")
public class EmpDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="phone_no",length=10)
	@NotEmpty(message="Phone number can not be empty")
	@Pattern(regexp="(^$|[0-9]{10})",message="Enter a valid number")
	private long phoneNo;
	
	@Column(name="address",length=100)
	@NotEmpty(message="Address can not be empty")
	private String address;
	
	@Column(name="date_of_birth")
	@DateTimeFormat(pattern="dd-MM-yyy")
	@JsonFormat(pattern = "dd-MM-yyyy")
	@NotEmpty(message="Date of birth can not be empty")
	private LocalDate dateOfBirth;
	
	@Column(name="lang_known",length=50)
	private String langKnown;
	
	@OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="emp_id",nullable = false)
	@JsonIgnore
	private Employee employee;
	
	@Column(name = "created_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonIgnore
	private LocalDate createdDate;
	
	@Column(name = "last_modified_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonIgnore
	private LocalDate lastModifiedDate;

	public EmpDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public EmpDetails(/*@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter a valid number") */long phoneNo, String address,
			LocalDate dateOfBirth, String langKnown) {
		this.phoneNo = phoneNo;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.langKnown = langKnown;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLangKnown() {
		return langKnown;
	}

	public void setLangKnown(String langKnown) {
		this.langKnown = langKnown;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDate lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "EmpDetails [id=" + id + ", phoneNo=" + phoneNo + ", address=" + address + ", dateOfBirth=" + dateOfBirth
				+ ", langKnown=" + langKnown + ", employee=" + employee + "]";
	}
	
	
}
