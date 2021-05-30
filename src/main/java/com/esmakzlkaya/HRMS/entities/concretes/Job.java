package com.esmakzlkaya.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Jobs")
@Data
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="department_id")
	private int departmentId;
	
	@Column(name="position_name")
	private String positionName;

}
