package com.esmakzlkaya.HRMS.core.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.esmakzlkaya.HRMS.entities.concretes.Employee;
import com.esmakzlkaya.HRMS.entities.concretes.Employer;
import com.esmakzlkaya.HRMS.entities.concretes.JobSeeker;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers"})
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_number")
	private String phone_number;
	
	@Column(name="password_hash")
	private byte[] passwordHash;
	
	@Column(name="password_salt")
	private byte[] passwordSalt;
	
	@Column(name="status")
	private boolean status;

	@OneToOne(mappedBy = "user")
	private Employer employer;
	
	@OneToOne(mappedBy = "user")
	private Employee employee;
	
	@OneToOne(mappedBy = "user")
	private JobSeeker jobSeeker;
}
