package com.esmakzlkaya.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Jobs")
public class Job {
	public Job() {
		super();
	}
	
	public Job(int id, int departmentId, String position_name) {
		super();
		this.id = id;
		this.departmentId = departmentId;
		this.positionName = position_name;
	}

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="department_id")
	private int departmentId;
	
	@Column(name="position_name")
	private String positionName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getPosition_name() {
		return positionName;
	}

	public void setPosition_name(String position_name) {
		this.positionName = position_name;
	}
}
