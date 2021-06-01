package com.esmakzlkaya.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.esmakzlkaya.HRMS.entities.concretes.CV;
import com.esmakzlkaya.HRMS.entities.dtos.CvWithFieldsDto;

public interface CVDao extends JpaRepository<CV, Integer>{
//
//	@Query("Select new com.esmakzlkaya.HRMS.entities.dtos.CvWithFieldsDto(c.id,c.imageUrl,j.firstName,j.lastName,j.email,j.birthDate, u.universityName,u.uniDepartmentName,u.uniEntranceDate,u.uniGraduationDate, jo.workplaceName,jo.positionName,jo.employmentStartDate,jo.terminationDate, l.languageName,l.level, t.Name, w.name,w.webPageUrl,c.coverLetter) "
//			+ " From CV c Inner Join c.jobSeeker j "
//			+ "inner join c.likesUniversity u "
//			+ "inner join c.likesJobExperience  jo "
//			+ "inner join c.likesLanguage l "
//			+ "inner join c.likesTechnology t "
//			+ "inner join c.likesWebPage w ")
//	List<CvWithFieldsDto> getCVWithFieldsDetails();
}
