package com.esmakzlkaya.HRMS.business.abstracts;

import java.sql.Date;
import java.util.List;

import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.entities.concretes.JobAdvert;

public interface JobAdvertService {

	Result add(JobAdvert jobAdvert);
	DataResult<List<JobAdvert>> getAllActive(); 
	DataResult<List<JobAdvert>> getByDate(Date releaseDate,Date deadline);
	DataResult<List<JobAdvert>> getByEmployer(int employerId);
	Result passivateAdvert(int id);
	
}
