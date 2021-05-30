package com.esmakzlkaya.HRMS.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esmakzlkaya.HRMS.business.abstracts.JobAdvertService;
import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.ErrorResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.core.utilities.results.SuccessDataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.SuccessResult;
import com.esmakzlkaya.HRMS.dataAccess.abstracts.JobAdvertDao;
import com.esmakzlkaya.HRMS.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{

	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		if(isJobAdvertFromValid(jobAdvert)) {
			jobAdvertDao.save(jobAdvert);
			return new SuccessResult("İş ilanı ekleme başarılı");
		}
		return new ErrorResult("İş ilanı formunda eksikler var");
	}

	private boolean isJobAdvertFromValid(JobAdvert jobAdvert) {
		if(jobAdvert.getJob().getId()!=0&&jobAdvert.getJobDefinition()!=null&&jobAdvert.getCity().getId()!=0&&jobAdvert.getOpenPositionNumber()!=0) {
			return true;
		}
		return false;
	}

	@Override
	public DataResult<List<JobAdvert>> getAllActive() {
		return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.findByStatus(true));
	}

	@Override
	public DataResult<List<JobAdvert>> getByDate(Date releaseDate, Date deadline) {
		return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.findByDate(releaseDate, deadline));
	}

	@Override
	public DataResult<List<JobAdvert>> getByEmployer(int employerId) {
		return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.findByEmployer(employerId));
	}

	@Override
	public Result passivateAdvert(int id) {
		JobAdvert advert=jobAdvertDao.findById(id);
		advert.setStatus(false);
		jobAdvertDao.save(advert);
		return new SuccessResult("İş ilanı pasif hale getirildi");
	}

}
