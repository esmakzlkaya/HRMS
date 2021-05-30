package com.esmakzlkaya.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esmakzlkaya.HRMS.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	Employer findByUserId(int userId);
}
