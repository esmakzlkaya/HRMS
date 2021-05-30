package com.esmakzlkaya.HRMS.business.concretes;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esmakzlkaya.HRMS.business.abstracts.JobSeekerService;
import com.esmakzlkaya.HRMS.business.abstracts.UserCheckService;
import com.esmakzlkaya.HRMS.core.adapters.MernisServiceAdapter;
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
	private MernisServiceAdapter mernisServiceAdapter;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,MernisServiceAdapter mernisServiceAdapter) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisServiceAdapter=mernisServiceAdapter;
	}

	@Override
	public Result add(JobSeeker jobSeeker) throws MalformedURLException {
		if(IsUserProfilesValid(jobSeeker)&&(IsMernisVerified(jobSeeker)&&(IsUserProfilesDuplicated(jobSeeker)==false))) {
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
		for(JobSeeker seeker:users) {
			if((jobSeeker.getEmail()==seeker.getEmail())||(seeker.getNationalityId()==jobSeeker.getNationalityId())) {
				return true;
			}
		}
		return false;
	}

	private boolean IsMernisVerified(JobSeeker jobSeeker) throws MalformedURLException {
		mernisServiceAdapter.CheckIfRealPerson(jobSeeker);
		if(this.mernisServiceAdapter.CheckIfRealPerson(jobSeeker)) 
		{
			System.out.println("Person is valid");
			return true;
		}else {
			System.out.println("Not a valid person");
			return false;
		}
	}

	private boolean IsUserProfilesValid(JobSeeker jobSeeker) {
		//JobSeekerDetailDto jobSeekerUser=jobSeekerDao.findByUserId(jobSeeker.getUserId());
		if(jobSeeker.getEmail()!=null&&jobSeeker.getBirthYear()!=0&&jobSeeker.getFirstName()!=null&&jobSeeker.getLastName()!=null&&jobSeeker.getNationalityId()!=null&&jobSeeker.getPassword()!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public DataResult<JobSeeker> findById(int id) {
		return new SuccessDataResult<JobSeeker>(jobSeekerDao.findById(id));
	}

	@Override
	public DataResult<List<JobSeeker>> findAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(),"Tüm İş arayanlar listelendi");
	}
	
	
}
