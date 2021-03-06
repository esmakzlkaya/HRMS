package com.esmakzlkaya.HRMS.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.esmakzlkaya.HRMS.business.abstracts.CVService;
import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.ErrorDataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.SuccessDataResult;
import com.esmakzlkaya.HRMS.entities.concretes.CV;

@RestController
@RequestMapping("/api/cvs")
public class CVsController {

	private CVService cvService;
	@Autowired
	public CVsController(CVService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@GetMapping("/getbyjobseeker")
	public DataResult<CV> getByJobSeeker(@RequestParam int jobSeekerId){
		return this.cvService.getByJobSeekerId(jobSeekerId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CV cv) {
		return ResponseEntity.ok(this.cvService.add(cv));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors=new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors=new ErrorDataResult<Object>(validationErrors,"Do??rulama hatalar??");
		return errors;
	}
}
