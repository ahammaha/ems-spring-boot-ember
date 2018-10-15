package com.maha.ems.employee;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maha.ems.enums.DesignationEnum;
import com.maha.ems.enums.EmpType;
import com.maha.ems.task.Task;

@Entity
@Table(name="employee")
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int id;

	@Column(name = "fname",length=30)
	@Size(min=2,max=30,message="First Name should be 2 to 30 characters long")
	@NotEmpty(message="First Name can not be empty")
	private String firstName;

	@Column(name = "lname",length=30)
	@NotEmpty(message="Last Name can not be empty")
	private String lastName;

	@Column(name = "password",length=20)
	private String password;

	@Column(name = "emp_type",length=20)
	private EmpType empType; // permanent or contract

	@Column(name = "email",length=40)
	@NotEmpty(message="Email  can not be empty")
	@Email(message="Not a valid email address")
	private String email;

	@Column(name = "date_of_joining")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateOfJoining;

	@Column(name = "designation",length=30)
	private DesignationEnum designation;
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
	@JsonIgnore
	private EmpDetails empDetails;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
    private Set<Task> tasks;
	
	@Column(name = "created_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonIgnore
	private LocalDate createdDate;
	
	@Column(name = "last_modified_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonIgnore
	private LocalDate lastModifiedDate;
	
	@Column(name="createdby")
	@JsonIgnore
	private int createdBy;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String firstName, String lastName, String password, EmpType empType, @Email String email,
			DesignationEnum designation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.empType = empType;
		this.email = email;
		this.designation = designation;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EmpType getEmpType() {
		return empType;
	}

	public void setEmpType(EmpType empType) {
		this.empType = empType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public EmpDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmpDetails empDetails) {
		this.empDetails = empDetails;
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

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", empType=" + empType + ", email=" + email + ", dateOfJoining=" + dateOfJoining
				+ ", designation=" + designation + "]";
	}
	
}
