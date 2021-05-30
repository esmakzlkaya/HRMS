package com.esmakzlkaya.HRMS.business.abstracts;

import java.net.MalformedURLException;

import com.esmakzlkaya.HRMS.entities.concretes.JobSeeker;

public interface UserCheckService {

	public boolean CheckIfRealPerson(JobSeeker jobSeeker) throws MalformedURLException;
}
