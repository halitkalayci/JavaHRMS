package com.kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="SystemUsers")
public class SystemUser {
	@Id
	@Column(name="`UserId`")
	private int userId;

	@Column(name="`Roles`")
	private String roles;
}
