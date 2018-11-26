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
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

	@Column(name = "email",length=40,unique=true)
	@NotEmpty(message="Email  can not be empty")
	@Email(message="Not a valid email address")
	private String email;
	
	@Column(name = "password",length=20)
	private String password;
	
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
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
	@Valid
	private Empdetails empdetails;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
    private Set<Task> tasks;
	
	public Employee() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Empdetails getEmpdetails() {
		return empdetails;
	}

	public void setEmpdetails(Empdetails empdetails) {
		this.empdetails = empdetails;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
