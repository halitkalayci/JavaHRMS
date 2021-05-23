package com.kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
     User findByEmail(String email);
     User findByEmailAndEmailVerifyCode(String email, String emailVerifyCode);
}
