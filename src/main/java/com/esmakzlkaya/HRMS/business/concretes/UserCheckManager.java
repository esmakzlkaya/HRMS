package com.esmakzlkaya.HRMS.business.concretes;

import java.net.MalformedURLException;

import org.springframework.stereotype.Service;

import com.esmakzlkaya.HRMS.business.abstracts.UserCheckService;
import com.esmakzlkaya.HRMS.entities.concretes.JobSeeker;
@Service
public class UserCheckManager implements UserCheckService{

	@Override
	public boolean CheckIfRealPerson(JobSeeker jobSeeker) throws MalformedURLException {
		return true;
	}

}
