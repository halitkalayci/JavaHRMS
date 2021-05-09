package com.kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.UserService;
import com.kodlama.io.hrms.dataAccess.abstracts.UserDao;
import com.kodlama.io.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{

	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public List<User> getAll() {
			return userDao.findAll();
	}
 
}
