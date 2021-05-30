package com.esmakzlkaya.HRMS.api.controllers;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esmakzlkaya.HRMS.business.abstracts.JobSeekerService;
import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.findAll();
	}
	
	@PostMapping("/add")
	Result add(@RequestBody JobSeeker jobSeeker) throws MalformedURLException {
		return this.jobSeekerService.add(jobSeeker);
	}
	
	
}
