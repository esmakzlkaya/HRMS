package com.esmakzlkaya.HRMS.business.concretes;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esmakzlkaya.HRMS.business.abstracts.JobSeekerService;
import com.esmakzlkaya.HRMS.business.abstracts.UserCheckService;
import com.esmakzlkaya.HRMS.core.entities.concretes.User;
import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.ErrorResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.core.utilities.results.SuccessDataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.SuccessResult;
import com.esmakzlkaya.HRMS.dataAccess.abstracts.JobSeekerDao;
import com.esmakzlkaya.HRMS.entities.concretes.JobSeeker;
@Service
public class JobSeekerManager implements JobSeekerService{
	
	private JobSeekerDao jobSeekerDao;
	private UserCheckService userCheckService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,UserCheckService userCheckService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userCheckService=userCheckService;
	}

	@Override
	public Result add(JobSeeker jobSeeker) throws MalformedURLException {
		if(IsUserProfilesValid(jobSeeker)&&(IsMernisVerified(jobSeeker)&&(IsUserProfilesDuplicated(jobSeeker)))) {
			EmailVerification();
			jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Kullanıcı ekleme başarılı");
		}
		return new ErrorResult("Kullanıcı bilgileri eksik veya hatalı");
	}

	private void EmailVerification() {
		System.out.println("E posta doğrulandı.");
	}

	private boolean IsUserProfilesDuplicated(JobSeeker jobSeeker) {
		List<JobSeeker> users= jobSeekerDao.findAll();
		User user=jobSeeker.getUser();
		for(JobSeeker seeker:users) {
			if(user.getEmail()==seeker.getUser().getEmail()||seeker.getNationalityId()==jobSeeker.getNationalityId()) {
				return false;
			}
		}
		return true;
	}

	private boolean IsMernisVerified(JobSeeker jobSeeker) throws MalformedURLException {
		userCheckService.CheckIfRealPerson(jobSeeker);
		if(this.userCheckService.CheckIfRealPerson(jobSeeker)) 
		{
			this.add(jobSeeker);
			return true;
		}else {
			return false;
		}
	}

	private boolean IsUserProfilesValid(JobSeeker jobSeeker) {
		//JobSeekerDetailDto jobSeekerUser=jobSeekerDao.findByUserId(jobSeeker.getUserId());
		User jobSeekerUser=jobSeeker.getUser();
		if(jobSeekerUser.getEmail()!=null&&jobSeeker.getBirthYear()!=0&&jobSeeker.getFirstName()!=null&&jobSeeker.getLastName()!=null&&jobSeeker.getNationalityId()!=null&&jobSeeker.getPassword()!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public DataResult<JobSeeker> findByUserId(int userId) {
		return new SuccessDataResult<JobSeeker>(jobSeekerDao.findByUserId(userId));
	}

	@Override
	public DataResult<List<JobSeeker>> findAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(),"Tüm İş arayanlar listelendi");
	}
	
	
}
