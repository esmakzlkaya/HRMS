package com.esmakzlkaya.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esmakzlkaya.HRMS.core.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findById(int id);
}
