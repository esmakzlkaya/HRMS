package com.esmakzlkaya.HRMS.business.abstracts;

import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.entities.concretes.CV;

public interface CVService {

	public Result add(CV cv); 
	public DataResult<CV> getByJobSeekerId(int jobSeekerId);
}
