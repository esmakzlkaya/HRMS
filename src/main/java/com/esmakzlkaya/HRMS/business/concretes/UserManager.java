package com.esmakzlkaya.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esmakzlkaya.HRMS.business.abstracts.UserService;
import com.esmakzlkaya.HRMS.core.entities.concretes.User;
import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.core.utilities.results.SuccessDataResult;
import com.esmakzlkaya.HRMS.dataAccess.abstracts.UserDao;
@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<User> findById(int id) {
		return new SuccessDataResult<User>(userDao.findById(id));
	}

	@Override
	public Result add(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
