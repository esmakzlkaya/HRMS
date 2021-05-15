package com.esmakzlkaya.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esmakzlkaya.HRMS.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{

}
