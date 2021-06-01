package com.esmakzlkaya.HRMS.entities.dtos;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CvWithFieldsDto {

	private int id;
	
	private String imageUrl;
	
	private String firstName;
	private String lastName;
	private String email;
	private Date birthDate;
	
	private String universityName;
	private String uniDepartmentName;
	private Date uniEntranceDate;
	private Date uniGraduationDate;
	
	private String workplaceName;
	private String positionName;
	private Date employmentStartDate;
	private Date terminationDate;
	
	private String languageName;
	private int level;
	
	private String technologyName;
	
	private String webPageName;
	private String webPageUrl;
	private String coverLetter;
	
	public CvWithFieldsDto(int id, String imageUrl, String firstName, String lastName, String email, Date birthDate,
			String universityName, String uniDepartmentName, Date uniEntranceDate, Date uniGraduationDate,
			String workplaceName, String positionName, Date employmentStartDate, Date terminationDate,
			String languageName, int level, String technologyName, String webPageName, String webPageUrl,String coverLetter) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthDate = birthDate;
		this.universityName = universityName;
		this.uniDepartmentName = uniDepartmentName;
		this.uniEntranceDate = uniEntranceDate;
		this.uniGraduationDate = uniGraduationDate;
		this.workplaceName = workplaceName;
		this.positionName = positionName;
		this.employmentStartDate = employmentStartDate;
		this.terminationDate = terminationDate;
		this.languageName = languageName;
		this.level = level;
		this.technologyName = technologyName;
		this.webPageName = webPageName;
		this.webPageUrl = webPageUrl;
		this.coverLetter=coverLetter;
	}
	
}
