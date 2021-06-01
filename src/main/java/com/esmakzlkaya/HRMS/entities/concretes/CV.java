package com.esmakzlkaya.HRMS.entities.concretes;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cvs")
@AllArgsConstructor
@NoArgsConstructor
public class CV {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@OneToMany(mappedBy = "cv")
	private List<Image> images;
	
	@Nullable
	@Column(name="cover_letter")
	private String coverLetter;
	
	@ManyToMany(mappedBy = "likedCvs")
    private Set<JobExperience> likesJobExperience;

	@ManyToMany(mappedBy = "likedCvs")
    private Set<Language> likesLanguage;
	
	@ManyToMany(mappedBy = "likedCvs")
    private Set<Technology> likesTechnology;
	
	@ManyToMany(mappedBy = "likedCvs")
    private Set<University> likesUniversity;
	
	@ManyToMany(mappedBy = "likedCvs")
    private Set<WebPage> likesWebPage;
	
}
