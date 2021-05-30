package com.esmakzlkaya.HRMS.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.esmakzlkaya.HRMS.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{

	JobSeeker findByUserId(int userId);
}
