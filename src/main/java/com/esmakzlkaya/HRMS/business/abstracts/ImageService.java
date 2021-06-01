package com.esmakzlkaya.HRMS.business.abstracts;

import java.util.List;

import com.esmakzlkaya.HRMS.core.utilities.results.DataResult;
import com.esmakzlkaya.HRMS.core.utilities.results.Result;
import com.esmakzlkaya.HRMS.entities.concretes.Image;

public interface ImageService {

	public DataResult<List<Image>> getByCv(int cvId);
	
	public Result add(Image image);
}
