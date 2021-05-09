package com.kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.SystemUserService;
import com.kodlama.io.hrms.dataAccess.abstracts.SystemUserDao;
import com.kodlama.io.hrms.entities.concretes.SystemUser;

@Service
public class SystemUserManager implements SystemUserService {
   private SystemUserDao systemUserDao;
@Autowired
public SystemUserManager(SystemUserDao systemUserDao) {
	super();
	this.systemUserDao = systemUserDao;
}

@Override
public List<SystemUser> getAll() {
	return this.systemUserDao.findAll();
}
   
}
