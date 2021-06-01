package com.esmakzlkaya.HRMS.entities.concretes;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="jobexperiences")
@AllArgsConstructor
@NoArgsConstructor
public class JobExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToMany
	private Set<CV> likedCvs;
	
	@NotBlank
	@NotNull
	@Column(name="workplace_name")
	private String workplaceName;
	
	@NotBlank
	@NotNull
	@Column(name="position_name")
	private String positionName;
	
	@NotBlank
	@NotNull
	@Column(name="employment_start_date")
	private Date employmentStartDate;
	
	@Nullable
	@Column(name="termination_date")
	private Date terminationDate;
}
