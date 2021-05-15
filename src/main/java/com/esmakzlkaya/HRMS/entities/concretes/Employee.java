package com.esmakzlkaya.HRMS.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {
	public Employee() {
		super();
	}

	public Employee(int id, int userId, int departmentId, int jobId, double comission, double salary, Date hireDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.departmentId = departmentId;
		this.jobId = jobId;
		this.comission = comission;
		this.salary = salary;
		this.hireDate = hireDate;
	}

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="department_id")
	private int departmentId;
	
	@Column(name="job_id")
	private int jobId;
	
	@Column(name="comission")
	private double comission;
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="hire_date")
	private Date hireDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public double getComission() {
		return comission;
	}

	public void setComission(double comission) {
		this.comission = comission;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
}
