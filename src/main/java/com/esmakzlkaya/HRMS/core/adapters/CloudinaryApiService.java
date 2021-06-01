package com.esmakzlkaya.HRMS.core.adapters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryApiService {

	private Map<String, String> valuesMap = new HashMap<>();
	
	Cloudinary cloudinary;
	public CloudinaryApiService() {
		valuesMap.put("cloud_name","" );
		valuesMap.put("api_key", "" );
		valuesMap.put("api_secret","" );
		cloudinary = new Cloudinary(valuesMap);
	}
	
	public Map upload(MultipartFile multipartFile) throws IOException{
		File file = convert(multipartFile);
		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		return uploadResult;
	}
	
	public File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(multipartFile.getBytes());
		stream.close();
		
		return file;
	}
	
	public Map delete (String id) throws IOException {
		Map deleteResult = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
		return deleteResult;
	}
}
