package com.esmakzlkaya.HRMS.business.abstracts;

import java.util.List;
import com.esmakzlkaya.HRMS.entities.concretes.Job;

public interface JobService {
	public List<Job> getAll();
}
