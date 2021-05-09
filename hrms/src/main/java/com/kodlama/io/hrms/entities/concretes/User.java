package com.kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Users")
public class User {

	@Id
	@GeneratedValue
	@Column(name="`Id`",nullable=false)
	private int id;
	
	@Column(name="`Email`",unique=true,nullable=false)
	private String email;
	
	@Column(name="`Password`",nullable=false)
	private String password;
	
	@Column(name="`EmailVerified`",nullable=false)
	private boolean emailVerified;
	
}
