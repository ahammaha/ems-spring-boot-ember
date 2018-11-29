package com.maha.ems.employee;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maha.ems.enums.DesignationEnum;
import com.maha.ems.enums.EmpType;

@Entity
@Table(name="empdetails")
public class Empdetails implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fname",length=30)
	@Size(min=2,max=30,message="First Name should be 2 to 30 characters long")
	@NotEmpty(message="First Name can not be empty")
	private String firstName;

	@Column(name = "lname",length=30)
	@NotEmpty(message="Last Name can not be empty")
	private String lastName;

	@Column(name = "emp_type",length=20)
	private EmpType empType; // permanent or contract
	
	@Column(name = "date_of_joining")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateOfJoining;

	@Column(name = "designation",length=30)
	private DesignationEnum designation;
	
	@Column(name="phone_no",length=10)
	@NotEmpty(message="Phone number can not be empty")
	@Size(min=10,max=10,message="Phone number should of length 10")
	@Pattern(regexp="(^$|[0-9]{10})",message="Enter a valid number")
	private String phoneNo;
	
	@Column(name="address",length=100)
	@NotEmpty(message="Address can not be empty")
	private String address;
	
	@Column(name="date_of_birth")
	@DateTimeFormat(pattern="dd-MM-yyy")
	@JsonFormat(pattern = "dd-MM-yyyy")
	@NotNull(message="Date of birth can not be empty")
	private LocalDate dateOfBirth;
	
	@Column(name="lang_known",length=50)
	private String langKnown;
	
	@OneToOne(fetch=FetchType.LAZY, optional=false)
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EmpType getEmpType() {
		return empType;
	}

	public void setEmpType(EmpType empType) {
		this.empType = empType;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public DesignationEnum getDesignation() {
		return designation;
	}

	public void setDesignation(DesignationEnum designation) {
		this.designation = designation;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EmpDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", empType=" + empType
				+ ", dateOfJoining=" + dateOfJoining + ", designation=" + designation + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", langKnown=" + langKnown + ", employee="
				+ employee + ", createdDate=" + createdDate + ", lastModifiedDate=" + lastModifiedDate + "]";
	}
	
}
