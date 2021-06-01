package com.esmakzlkaya.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esmakzlkaya.HRMS.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{

	List<Image> getByCv(int cvId);
}
