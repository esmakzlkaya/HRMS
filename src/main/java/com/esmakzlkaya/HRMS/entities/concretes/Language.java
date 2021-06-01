package com.esmakzlkaya.HRMS.entities.concretes;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="languages")
@AllArgsConstructor
@NoArgsConstructor
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToMany
	private Set<CV> likedCvs;
	
	@NotBlank
	@NotNull
	@Column(name="language_name")
	private String languageName;
	
	@NotBlank
	@NotNull
	@Column(name="level")
	private int level;
}
