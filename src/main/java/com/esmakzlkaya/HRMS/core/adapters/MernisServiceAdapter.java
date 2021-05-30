package com.esmakzlkaya.HRMS.core.adapters;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.esmakzlkaya.HRMS.business.abstracts.UserCheckService;
import com.esmakzlkaya.HRMS.entities.concretes.JobSeeker;

import tr.gov.nvi.tckimlik.ws.KPSPublic;
import tr.gov.nvi.tckimlik.ws.KPSPublicSoap;
@Service
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean CheckIfRealPerson(JobSeeker jobSeeker) throws MalformedURLException {
		String endpoint= "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx";
		URL url=java.net.URI.create(endpoint).toURL();
		
		KPSPublic service= new KPSPublic(url);
		KPSPublicSoap port=service.getPort(KPSPublicSoap.class);
		return port.tcKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalityId()), jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getBirthYear());
	}

	
}
