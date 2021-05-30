package com.esmakzlkaya.HRMS.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.esmakzlkaya.HRMS.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

	JobAdvert findById(int id);
	
	@Query("From JobAdvert where status=:status")
	List<JobAdvert> findByStatus(boolean status);
	
	@Query("From JobAdvert where status=true and releaseDate=:releaseDate and deadline=:deadline ")
	List<JobAdvert> findByDate(Date releaseDate,Date deadline);
	
	@Query("From JobAdvert where status=true and employer_id=:employerId")
	List<JobAdvert> findByEmployer(int employerId);
}
