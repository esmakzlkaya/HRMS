package com.esmakzlkaya.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esmakzlkaya.HRMS.business.abstracts.CVService;
import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.core.utilities.results.SuccessDataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.SuccessResult;
import com.esmakzlkaya.HRMS.dataAccess.abstracts.CVDao;
import com.esmakzlkaya.HRMS.entities.concretes.CV;

@Service
public class CVManager implements CVService{

	private CVDao cvDao;
	
	@Autowired
	public CVManager(CVDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public Result add(CV cv) {
		cvDao.save(cv);
		return new SuccessResult("Cv kaydedildi");
	}

	@Override
	public DataResult<CV> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<CV>(cvDao.getByJobSeekerId(jobSeekerId));
	}

	
}
