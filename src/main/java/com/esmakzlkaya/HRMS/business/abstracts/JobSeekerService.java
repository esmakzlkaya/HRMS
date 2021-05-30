package com.esmakzlkaya.HRMS.business.abstracts;

import java.net.MalformedURLException;
import java.util.List;

import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.entities.concretes.JobSeeker;

public interface JobSeekerService {

	Result add(JobSeeker jobSeeker) throws MalformedURLException;
	DataResult<JobSeeker> findByUserId(int id);
	DataResult<List<JobSeeker>> findAll();
}
