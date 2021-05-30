package com.esmakzlkaya.HRMS.entities.concretes;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.esmakzlkaya.HRMS.core.entities.concretes.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Employees")
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
//	@Column(name="user_id")
//	private int userId;
	
	@Column(name="e_mail")
	private String email;

	@Column(name="password")
	private String password;
	
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
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="user_id",referencedColumnName = "id")
//	private User user;

}
