package com.esmakzlkaya.HRMS.business.abstracts;

import java.util.List;

import com.esmakzlkaya.HRMS.core.entities.concretes.User;
import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.entities.concretes.Job;

public interface UserService {

	DataResult<List<User>> getAll();
	DataResult<User> findById(int id);
	Result add(User user);
}
