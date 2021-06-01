package com.esmakzlkaya.HRMS.entities.concretes;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name="universities")
@AllArgsConstructor
@NoArgsConstructor
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToMany
	private Set<CV> likedCvs;
	
	@NotBlank
	@NotNull
	@Column(name="university_name")
	private String universityName;
	
	@NotBlank
	@NotNull
	@Column(name="uni_department_name")
	private String uniDepartmentName;
	
	@NotBlank
	@NotNull
	@Column(name="uni_entrance_date")
	private Date uniEntranceDate;
	
	@Nullable
	@Column(name="uni_graduation_date")
	private Date uniGraduationDate;
}
