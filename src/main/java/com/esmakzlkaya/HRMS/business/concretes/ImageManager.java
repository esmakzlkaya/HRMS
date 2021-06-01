package com.esmakzlkaya.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esmakzlkaya.HRMS.business.abstracts.ImageService;
import com.esmakzlkaya.HRMS.core.adapters.CloudinaryApiService;
import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.core.utilities.results.SuccessDataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.SuccessResult;
import com.esmakzlkaya.HRMS.dataAccess.abstracts.ImageDao;
import com.esmakzlkaya.HRMS.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{

	private ImageDao imageDao;
	//private CloudinaryApiService cloudinaryService;
	
	@Autowired
	public ImageManager(ImageDao imageDao) {
		super();
		this.imageDao = imageDao;
	}
	
	@Override
	public DataResult<List<Image>> getByCv(int cvId) {
		return new SuccessDataResult<List<Image>>(imageDao.getByCvId(cvId));
	}

	@Override
	public Result add(Image image) {
		imageDao.save(image);
		return new SuccessResult("Aday fotoğrafı eklendi");
	}

}
