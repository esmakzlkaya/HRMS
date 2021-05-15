package com.esmakzlkaya.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Departments")
public class Department {
	public Department() {
		
	}
	
	public Department(int id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
	}
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="department_name")
	private String departmentName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
