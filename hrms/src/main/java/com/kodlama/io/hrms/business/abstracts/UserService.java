package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.entities.concretes.User;

public interface UserService {
	List<User> getAll();
}
