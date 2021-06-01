package com.esmakzlkaya.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esmakzlkaya.HRMS.business.abstracts.ImageService;
import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.entities.concretes.Image;

@RestController
@RequestMapping("/api/images")
public class ImagesController {

	private ImageService imageService;

	@Autowired
	public ImagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@GetMapping("/getbycv")
	public DataResult<List<Image>> getByCv(@RequestParam int cvId){
		return this.imageService.getByCv(cvId);		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Image image){
		return this.imageService.add(image);	
	}
}
