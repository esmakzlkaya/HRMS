package com.esmakzlkaya.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="Jobs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_adverts"})
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
	
	@OneToMany(mappedBy = "job")
	private List<JobAdvert> adverts;

}
