package com.esmakzlkaya.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esmakzlkaya.HRMS.business.abstracts.JobService;
import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.ErrorResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.core.utilities.results.SuccessDataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.SuccessResult;
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
	public DataResult<List<Job>> findAll() {
		return new SuccessDataResult<List<Job>>(jobDao.findAll(),"Tüm iş pozisyonları listelendi");
	}

	@Override
	public Result add(Job job) {
		if(IsJobPositionNameAvailable(job.getPositionName())) {
			jobDao.save(job);
			return new SuccessResult("Yeni iş pozisyonu eklendi");	
		}else {
			return new ErrorResult("Bu isimde bir iş pozisyonu zaten var");
		}
	}

	private boolean IsJobPositionNameAvailable(String job_name) {
		List<Job> jobs=jobDao.findAll();
		for(Job job:jobs) {
			if(job.getPositionName()==job_name) {
				return false;
			}
		}
		return true;
	}

}
