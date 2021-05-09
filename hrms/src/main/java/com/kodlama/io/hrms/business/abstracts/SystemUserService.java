package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.entities.concretes.SystemUser;

public interface SystemUserService {
   List<SystemUser> getAll();
}
