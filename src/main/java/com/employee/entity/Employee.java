package com.employee.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="salary")
	private Double salary;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="joiningdate")
	private Date joiningDate;
	
	@Column(name="exitdate")
	private Date exitDate;
	
	@ManyToOne
	@JoinColumn(name="manager")
	private Manager manager;

	@OneToOne
	@JoinColumn(name = "system")
	private System system;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}


	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}


	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}
}
