package com.esmakzlkaya.HRMS.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="job_adverts")
public class JobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JoinColumn(name="employer_id")
	@ManyToOne()
	private Employer employer;
	
	@JoinColumn(name="city_id")
	@ManyToOne()
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private Job job;
	
	@Column(name="job_definition")
	private String jobDefinition;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="open_position_number")
	private int openPositionNumber;
	
	@Column(name="release_date")
	private Date releaseDate;
	
	@Column(name="deadline")
	private Date deadline;
	
	@Column(name="status")
	private boolean status;
	
	
}
