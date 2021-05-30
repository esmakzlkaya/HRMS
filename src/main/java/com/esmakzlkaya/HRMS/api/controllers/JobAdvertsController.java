package com.esmakzlkaya.HRMS.api.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esmakzlkaya.HRMS.business.abstracts.JobAdvertService;
import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {
	private JobAdvertService jobAdvertService;
	
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getallactive")
	public DataResult<List<JobAdvert>> getAllActive(){
		return this.jobAdvertService.getAllActive();
	}
	
	@GetMapping("/getallbydate")
	public DataResult<List<JobAdvert>> getAllByDate(@RequestParam Date releaseDate,@RequestParam Date deadline){
		return this.jobAdvertService.getByDate(releaseDate, deadline);
	}
	
	@GetMapping("/getAllbyemployer")
	public DataResult<List<JobAdvert>> getAllByEmployerId(@RequestParam int employerId){
		return this.jobAdvertService.getByEmployer(employerId);
	}
	
	@PostMapping("/setPassive")
	public Result passivateAdvert(@RequestParam int id) {
		return this.jobAdvertService.passivateAdvert(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}

}
