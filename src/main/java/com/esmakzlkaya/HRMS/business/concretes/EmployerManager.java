package com.esmakzlkaya.HRMS.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esmakzlkaya.HRMS.business.abstracts.EmployerService;
import com.esmakzlkaya.HRMS.core.entities.concretes.User;
import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.ErrorResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.core.utilities.results.SuccessDataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.SuccessResult;
import com.esmakzlkaya.HRMS.dataAccess.abstracts.EmployerDao;
import com.esmakzlkaya.HRMS.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result add(Employer employer) {
		if(IsUserProfilesValid(employer)&&(IsUserProfilesDuplicated(employer)&&(CheckIfMailValid(employer)))) {
			EmailVerification(employer);
			HrmsSystemVerification(employer);
			employerDao.save(employer);
			return new SuccessResult("İşveren kullanıcısı ekleme başarılı.");
		}
		return new ErrorResult("Kullanıcı bilgileri eksik veya hatalı.");
	}

	private void HrmsSystemVerification(Employer employer) {
		System.out.println("İşveren kullanıcısı kaydı onaylandı "+employer.getCompanyName());
		
	}

	private void EmailVerification(Employer employer) {
		System.out.println("E posta doğrulandı "+employer.getCompanyName());
		
	}

	private boolean CheckIfMailValid(Employer employer) {
		String employerMail=employer.getUser().getEmail();
		String employerWebSite=employer.getWebSite();
		String translation=translateTrToEng(employerWebSite);
		String regexString="^[A-Z0-9._%+-]+@"+translation+"?$";
		boolean result=true;
		Pattern pattern=Pattern.compile(regexString,Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(employerMail);
		if(!matcher.matches()) {
			result=false;
		}
		return result;
	}
	public String translateTrToEng(String input)
	{
	   String translationInput = input;
	   String result = "";
	   char[] tr = new char[] { 'İ', 'ı','ü', 'Ü', 'ç', 'Ç','Ğ', 'ğ','Ş', 'ş','ö','Ö' };
	   char[] eng = new char[] { 'i', 'i', 'u','u','c','c','g','g','s', 's','o','o', };
	  
	   for (int sayac = 0; sayac < tr.length; sayac++)
	   {
	      result = translationInput.replace(tr[sayac], eng[sayac]);
	   }
	   return result;
	}
	
	private boolean IsUserProfilesDuplicated(Employer employer) {
		List<Employer> users=employerDao.findAll();
	//	EmployerDetailDto employerUser=employerDao.findByUserId(employer.getUserId());
		for(Employer user:users) {
			if(user.getUser().getEmail()==employer.getUser().getEmail()) {
				return false;
			}
		}
		return true;
	}

	private boolean IsUserProfilesValid(Employer employer) {
		//EmployerDetailDto user=employerDao.findByUserId(employer.getUserId());
		User user=employer.getUser();
		if(employer.getCompanyName()!=null&&user.getEmail()!=null&&employer.getPassword()!=null&&employer.getWebSite()!=null&&user.getPhone_number()!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public DataResult<List<Employer>> findAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Tüm İşverenler listelendi");
	}

}
