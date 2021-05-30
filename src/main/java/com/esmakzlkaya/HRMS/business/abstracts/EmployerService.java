package com.esmakzlkaya.HRMS.business.abstracts;

import java.util.List;

import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.entities.concretes.Employer;

public interface EmployerService {

	Result add(Employer employer);
	DataResult<List<Employer>> findAll();
}
