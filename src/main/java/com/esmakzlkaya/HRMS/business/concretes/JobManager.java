package com.esmakzlkaya.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esmakzlkaya.HRMS.business.abstracts.JobService;
import com.esmakzlkaya.HRMS.dataAccess.abstracts.JobDao;
import com.esmakzlkaya.HRMS.entities.concretes.Job;


@Service
public class JobManager implements JobService{
	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}
	
	@Override
	public List<Job> getAll() {
		return jobDao.findAll();
	}

}
